package com.chinapost.devp.generate.web.rest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.common.util.DateUtil;
import com.chinapost.devp.generate.excel.handler.TemplateCellStyleStrategy;
import com.chinapost.devp.generate.excel.handler.TitleDescriptionWriteHandler;
import com.chinapost.devp.generate.excel.listener.SyncReadExcelListener;
import com.chinapost.devp.generate.pojo.dto.DemandsAddDTO;
import com.chinapost.devp.generate.pojo.dto.DemandsExcelDTO;
import com.chinapost.devp.generate.pojo.dto.DemandsUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.DemandsMapper;
import com.chinapost.devp.generate.pojo.po.DemandsPO;
import com.chinapost.devp.generate.pojo.qo.DemandsQO;
import com.chinapost.devp.generate.pojo.vo.DemandsExcelVO;
import com.chinapost.devp.generate.pojo.vo.DemandsListVO;
import com.chinapost.devp.generate.pojo.vo.DemandsShowVO;
import com.chinapost.devp.generate.service.DemandsService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.DemandsAPI;
import com.chinapost.devp.generate.web.constant.WebConst;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 【需求列表】控制器
 *
 * @author wn
 * @date 2021/01/22
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/demands")
public class DemandsController extends AbstractController implements DemandsAPI {

    @Autowired
    private DemandsService demandsService;
    @Autowired
    private Validator validator;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DemandsShowVO> save(@Valid @RequestBody DemandsAddDTO demandsAddDTO) throws Exception {
        DemandsPO demands = demandsService.save(demandsAddDTO);
        return ResponseEntity.created(new URI(WebConst.API_PATH + "/demands/" + demands.getId()))
                .body(DemandsMapper.INSTANCE.toShowVO(demands));
    }

    @Override
    @PutMapping
    public ResponseEntity<DemandsShowVO> update(@Valid @RequestBody DemandsUpdateDTO demandsUpdateDTO) {
        DemandsPO demands = demandsService.update(demandsUpdateDTO);
        return ResponseEntity.ok(DemandsMapper.INSTANCE.toShowVO(demands));
    }

    @Override
    @GetMapping
    public ResponseEntity<PageVO<DemandsListVO>> list(@Valid DemandsQO demandsQO) {
        PageVO<DemandsListVO> page = demandsService.list(demandsQO);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<DemandsShowVO> show(@PathVariable Long id) {
        DemandsShowVO demandsShowVO = demandsService.show(id);
        return ResponseEntity.ok(demandsShowVO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Long id) {
        int count = demandsService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody Long[] id) {
        if (ArrayUtils.isEmpty(id)) {
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = demandsService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/export")
    public void exportExcel(@Valid DemandsQO demandsQO, HttpServletResponse response) throws Exception {
        demandsQO.setPageSize(Integer.MAX_VALUE);
        // demandsQO.setPageNo(1);
        demandsQO.setCurrentPage(1);
        List<DemandsListVO> list = demandsService.list(demandsQO).getList();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("需求列表导出", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DemandsExcelVO.class)
                .sheet()
                .doWrite(DemandsMapper.INSTANCE.toExcelVOList(list));
    }

    @Override
    @PostMapping("/import")
    public ResponseEntity<Integer> importExcel(@RequestPart MultipartFile file) throws Exception {
        SyncReadExcelListener<DemandsExcelDTO> excelListener = new SyncReadExcelListener();
        EasyExcel.read(file.getInputStream())
                .head(DemandsExcelDTO.class)
                .sheet()
                .headRowNumber(3)
                .registerReadListener(excelListener)
                .doRead();
        List<DemandsAddDTO> list = excelListener.getList().stream()
                .map(excelDTO -> {
                    DemandsAddDTO addDTO = DemandsMapper.INSTANCE.fromExcelDTO(excelDTO);
                    // 校验数据
                    Set<ConstraintViolation<DemandsAddDTO>> set = validator.validate(addDTO);
                    if (!set.isEmpty()) {
                        ConstraintViolation<DemandsAddDTO> violation = set.stream().findFirst().get();
                        String errorMsg = "第" + (excelDTO.getRowIndex() + 1) + "行数据不合法：" + violation.getMessage();
                        throw new ConstraintViolationException(errorMsg, set);
                    }
                    return addDTO;
                })
                .collect(Collectors.toList());
        int count = demandsService.batchSave(list);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/template")
    public void downloadExcelTemplate(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String title = "需求列表导入模板(" + DateUtil.getDateStr(new Date()) + ")";
        String fileName = URLEncoder.encode(title, "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        String[] description = new String[]{
                "模版前三行标题请勿修改",
                "带“*”号为必填项",
        };
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                // 第一行是标题，第二行是说明
                .registerWriteHandler(new TitleDescriptionWriteHandler(title, description, DemandsExcelDTO.class))
                // 自定义模板单元格样式
                .registerWriteHandler(new TemplateCellStyleStrategy())
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "Sheet1")
                .head(DemandsExcelDTO.class)
                // 从第三行开始写表头
                .relativeHeadRowIndex(2)
                .build();
        excelWriter.write(Arrays.asList(DemandsExcelDTO.example()), writeSheet);

        excelWriter.finish();
    }

}


