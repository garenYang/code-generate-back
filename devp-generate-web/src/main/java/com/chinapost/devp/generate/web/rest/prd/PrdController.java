package com.chinapost.devp.generate.web.rest.prd;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.pojo.qo.OptionQO;
import com.chinapost.devp.common.pojo.vo.OptionVO;
import com.chinapost.devp.common.pojo.vo.PageVO;
import com.chinapost.devp.common.util.DateUtil;
import com.chinapost.devp.generate.excel.handler.TemplateCellStyleStrategy;
import com.chinapost.devp.generate.excel.handler.TitleDescriptionWriteHandler;
import com.chinapost.devp.generate.excel.listener.SyncReadExcelListener;
import com.chinapost.devp.generate.pojo.dto.prd.PrdAddDTO;
import com.chinapost.devp.generate.pojo.dto.prd.PrdExcelDTO;
import com.chinapost.devp.generate.pojo.dto.prd.PrdUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.prd.PrdMapper;
import com.chinapost.devp.generate.pojo.po.prd.PrdPO;
import com.chinapost.devp.generate.pojo.qo.prd.PrdQO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdExcelVO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdListVO;
import com.chinapost.devp.generate.pojo.vo.prd.PrdShowVO;
import com.chinapost.devp.generate.pojo.vo.tree.TreeNode;
import com.chinapost.devp.generate.service.prd.PrdService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.prd.PrdAPI;
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
 * 【需求文档管理】控制器
 *
 * @author wn
 * @date 2021/01/22
 */
@RestController
@RequestMapping(WebConst.ModulePath.PRD)
public class PrdController extends AbstractController implements PrdAPI {

    @Autowired
    private PrdService prdService;
    @Autowired
    private Validator validator;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PrdShowVO> save(@Valid @RequestBody PrdAddDTO prdAddDTO) throws Exception {
        PrdPO prd = prdService.save(prdAddDTO);
        return ResponseEntity.created(new URI(WebConst.ModulePath.PRD + "/prd/" + prd.getId()))
                .body(PrdMapper.INSTANCE.toShowVO(prd));
    }

    @Override
    @PutMapping
    public ResponseEntity<PrdShowVO> update(@Valid @RequestBody PrdUpdateDTO prdUpdateDTO) {
        PrdPO prd = prdService.update(prdUpdateDTO);
        return ResponseEntity.ok(PrdMapper.INSTANCE.toShowVO(prd));
    }

    @Override
    @GetMapping
    public ResponseEntity<PageVO<PrdListVO>> list(@Valid PrdQO prdQO) {
        PageVO<PrdListVO> page = prdService.list(prdQO);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping(value = "/trees")
    public ResponseEntity<List<TreeNode>> listTrees(String projectGroupId) {
        List<TreeNode> treeNodes = prdService.listTrees(projectGroupId);
        return ResponseEntity.ok(treeNodes);
    }

    @Override
    @GetMapping(value = "/options")
    public ResponseEntity<List<OptionVO<String, String>>> findOptions(OptionQO<String, String> qo) {
        List<OptionVO<String, String>> options = prdService.findOptions(qo);
        return ResponseEntity.ok(options);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<PrdShowVO> show(@PathVariable String id) {
        PrdShowVO prdShowVO = prdService.show(id);
        return ResponseEntity.ok(prdShowVO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable String id) {
        int count = prdService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody String[] id) {
        if (ArrayUtils.isEmpty(id)) {
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = prdService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/export")
    public void exportExcel(@Valid PrdQO prdQO, HttpServletResponse response) throws Exception {
        prdQO.setPageSize(Integer.MAX_VALUE);
        prdQO.setCurrentPage(1);
        List<PrdListVO> list = prdService.list(prdQO).getList();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("需求文档管理导出", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), PrdExcelVO.class)
                .sheet()
                .doWrite(PrdMapper.INSTANCE.toExcelVOList(list));
    }

    @Override
    @PostMapping("/import")
    public ResponseEntity<Integer> importExcel(@RequestPart MultipartFile file) throws Exception {
        SyncReadExcelListener<PrdExcelDTO> excelListener = new SyncReadExcelListener();
        EasyExcel.read(file.getInputStream())
                .head(PrdExcelDTO.class)
                .sheet()
                .headRowNumber(3)
                .registerReadListener(excelListener)
                .doRead();
        List<PrdAddDTO> list = excelListener.getList().stream()
                .map(excelDTO -> {
                    PrdAddDTO addDTO = PrdMapper.INSTANCE.fromExcelDTO(excelDTO);
                    // 校验数据
                    Set<ConstraintViolation<PrdAddDTO>> set = validator.validate(addDTO);
                    if (!set.isEmpty()) {
                        ConstraintViolation<PrdAddDTO> violation = set.stream().findFirst().get();
                        String errorMsg = "第" + (excelDTO.getRowIndex() + 1) + "行数据不合法：" + violation.getMessage();
                        throw new ConstraintViolationException(errorMsg, set);
                    }
                    return addDTO;
                })
                .collect(Collectors.toList());
        int count = prdService.batchSave(list);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/template")
    public void downloadExcelTemplate(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String title = "需求文档管理导入模板(" + DateUtil.getDateStr(new Date()) + ")";
        String fileName = URLEncoder.encode(title, "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        String[] description = new String[]{
                "模版前三行标题请勿修改",
                "带“*”号为必填项",
        };
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                // 第一行是标题，第二行是说明
                .registerWriteHandler(new TitleDescriptionWriteHandler(title, description, PrdExcelDTO.class))
                // 自定义模板单元格样式
                .registerWriteHandler(new TemplateCellStyleStrategy())
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "Sheet1")
                .head(PrdExcelDTO.class)
                // 从第三行开始写表头
                .relativeHeadRowIndex(2)
                .build();
        excelWriter.write(Arrays.asList(PrdExcelDTO.example()), writeSheet);

        excelWriter.finish();
    }

}


