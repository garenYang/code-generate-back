package com.chinapost.devp.generate.web.rest.fsd;

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
import com.chinapost.devp.generate.pojo.dto.fsd.FsdAddDTO;
import com.chinapost.devp.generate.pojo.dto.fsd.FsdExcelDTO;
import com.chinapost.devp.generate.pojo.dto.fsd.FsdUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.fsd.FsdMapper;
import com.chinapost.devp.generate.pojo.po.fsd.FsdPO;
import com.chinapost.devp.generate.pojo.qo.fsd.FsdQO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdExcelVO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdListVO;
import com.chinapost.devp.generate.pojo.vo.fsd.FsdShowVO;
import com.chinapost.devp.generate.service.fsd.FsdService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.fsd.FsdAPI;
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
 * 【模块功能点】控制器
 *
 * @author wn
 * @date 2021/01/22
 */
@RestController
@RequestMapping(WebConst.ModulePath.FSD)
public class FsdController extends AbstractController implements FsdAPI {

    @Autowired
    private FsdService fsdService;
    @Autowired
    private Validator validator;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FsdShowVO> save(@Valid @RequestBody FsdAddDTO fsdAddDTO) throws Exception {
        FsdPO fsd = fsdService.save(fsdAddDTO);
        return ResponseEntity.created(new URI(WebConst.ModulePath.FSD + "/fsd/" + fsd.getId()))
                .body(FsdMapper.INSTANCE.toShowVO(fsd));
    }

    @Override
    @PutMapping
    public ResponseEntity<FsdShowVO> update(@Valid @RequestBody FsdUpdateDTO fsdUpdateDTO) {
        FsdPO fsd = fsdService.update(fsdUpdateDTO);
        return ResponseEntity.ok(FsdMapper.INSTANCE.toShowVO(fsd));
    }

    @Override
    @GetMapping
    public ResponseEntity<PageVO<FsdListVO>> list(@Valid FsdQO fsdQO) {
        PageVO<FsdListVO> page = fsdService.list(fsdQO);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<FsdShowVO> show(@PathVariable String id) {
        FsdShowVO fsdShowVO = fsdService.show(id);
        return ResponseEntity.ok(fsdShowVO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable String id) {
        int count = fsdService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody String[] id) {
        if (ArrayUtils.isEmpty(id)) {
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = fsdService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/export")
    public void exportExcel(@Valid FsdQO fsdQO, HttpServletResponse response) throws Exception {
        fsdQO.setPageSize(Integer.MAX_VALUE);
        fsdQO.setCurrentPage(1);
        List<FsdListVO> list = fsdService.list(fsdQO).getList();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("模块功能点导出", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), FsdExcelVO.class)
                .sheet()
                .doWrite(FsdMapper.INSTANCE.toExcelVOList(list));
    }

    @Override
    @PostMapping("/import")
    public ResponseEntity<Integer> importExcel(@RequestPart MultipartFile file) throws Exception {
        SyncReadExcelListener<FsdExcelDTO> excelListener = new SyncReadExcelListener();
        EasyExcel.read(file.getInputStream())
                .head(FsdExcelDTO.class)
                .sheet()
                .headRowNumber(3)
                .registerReadListener(excelListener)
                .doRead();
        List<FsdAddDTO> list = excelListener.getList().stream()
                .map(excelDTO -> {
                    FsdAddDTO addDTO = FsdMapper.INSTANCE.fromExcelDTO(excelDTO);
                    // 校验数据
                    Set<ConstraintViolation<FsdAddDTO>> set = validator.validate(addDTO);
                    if (!set.isEmpty()) {
                        ConstraintViolation<FsdAddDTO> violation = set.stream().findFirst().get();
                        String errorMsg = "第" + (excelDTO.getRowIndex() + 1) + "行数据不合法：" + violation.getMessage();
                        throw new ConstraintViolationException(errorMsg, set);
                    }
                    return addDTO;
                })
                .collect(Collectors.toList());
        int count = fsdService.batchSave(list);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/template")
    public void downloadExcelTemplate(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String title = "模块功能点导入模板(" + DateUtil.getDateStr(new Date()) + ")";
        String fileName = URLEncoder.encode(title, "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        String[] description = new String[]{
                "模版前三行标题请勿修改",
                "带“*”号为必填项",
                "“功能模块ID”请填入id值",
        };
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                // 第一行是标题，第二行是说明
                .registerWriteHandler(new TitleDescriptionWriteHandler(title, description, FsdExcelDTO.class))
                // 自定义模板单元格样式
                .registerWriteHandler(new TemplateCellStyleStrategy())
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "Sheet1")
                .head(FsdExcelDTO.class)
                // 从第三行开始写表头
                .relativeHeadRowIndex(2)
                .build();
        excelWriter.write(Arrays.asList(FsdExcelDTO.example()), writeSheet);

        excelWriter.finish();
    }

}


