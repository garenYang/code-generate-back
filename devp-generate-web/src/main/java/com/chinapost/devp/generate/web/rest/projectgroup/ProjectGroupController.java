package com.chinapost.devp.generate.web.rest.projectgroup;

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
import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupAddDTO;
import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupExcelDTO;
import com.chinapost.devp.generate.pojo.dto.projectgroup.ProjectGroupUpdateDTO;
import com.chinapost.devp.generate.pojo.mapper.projectgroup.ProjectGroupMapper;
import com.chinapost.devp.generate.pojo.po.projectgroup.ProjectGroupPO;
import com.chinapost.devp.generate.pojo.qo.projectgroup.ProjectGroupQO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupExcelVO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupListVO;
import com.chinapost.devp.generate.pojo.vo.projectgroup.ProjectGroupShowVO;
import com.chinapost.devp.generate.service.projectgroup.ProjectGroupService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.projectgroup.ProjectGroupAPI;
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
 * 【项目集】控制器
 *
 * @author wn
 * @date 2021/01/22
 */
@RestController
@RequestMapping(WebConst.ModulePath.PROJECTGROUP + "/projectGroup")
public class ProjectGroupController extends AbstractController implements ProjectGroupAPI {

    @Autowired
    private ProjectGroupService projectGroupService;
    @Autowired
    private Validator validator;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProjectGroupShowVO> save(@Valid @RequestBody ProjectGroupAddDTO projectGroupAddDTO) throws Exception {
        ProjectGroupPO projectGroup = projectGroupService.save(projectGroupAddDTO);
        return ResponseEntity.created(new URI(WebConst.ModulePath.PROJECTGROUP + "/projectGroup/" + projectGroup.getId()))
                .body(ProjectGroupMapper.INSTANCE.toShowVO(projectGroup));
    }

    @Override
    @PutMapping
    public ResponseEntity<ProjectGroupShowVO> update(@Valid @RequestBody ProjectGroupUpdateDTO projectGroupUpdateDTO) {
        ProjectGroupPO projectGroup = projectGroupService.update(projectGroupUpdateDTO);
        return ResponseEntity.ok(ProjectGroupMapper.INSTANCE.toShowVO(projectGroup));
    }

    @Override
    @GetMapping
    public ResponseEntity<PageVO<ProjectGroupListVO>> list(@Valid ProjectGroupQO projectGroupQO) {
        PageVO<ProjectGroupListVO> page = projectGroupService.list(projectGroupQO);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectGroupShowVO> show(@PathVariable String id) {
        ProjectGroupShowVO projectGroupShowVO = projectGroupService.show(id);
        return ResponseEntity.ok(projectGroupShowVO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable String id) {
        int count = projectGroupService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody String[] id) {
        if (ArrayUtils.isEmpty(id)) {
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = projectGroupService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/export")
    public void exportExcel(@Valid ProjectGroupQO projectGroupQO, HttpServletResponse response) throws Exception {
        projectGroupQO.setPageSize(Integer.MAX_VALUE);
        projectGroupQO.setCurrentPage(1);
        List<ProjectGroupListVO> list = projectGroupService.list(projectGroupQO).getList();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("项目集导出", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ProjectGroupExcelVO.class)
                .sheet()
                .doWrite(ProjectGroupMapper.INSTANCE.toExcelVOList(list));
    }

    @Override
    @PostMapping("/import")
    public ResponseEntity<Integer> importExcel(@RequestPart MultipartFile file) throws Exception {
        SyncReadExcelListener<ProjectGroupExcelDTO> excelListener = new SyncReadExcelListener();
        EasyExcel.read(file.getInputStream())
                .head(ProjectGroupExcelDTO.class)
                .sheet()
                .headRowNumber(3)
                .registerReadListener(excelListener)
                .doRead();
        List<ProjectGroupAddDTO> list = excelListener.getList().stream()
                .map(excelDTO -> {
                    ProjectGroupAddDTO addDTO = ProjectGroupMapper.INSTANCE.fromExcelDTO(excelDTO);
                    // 校验数据
                    Set<ConstraintViolation<ProjectGroupAddDTO>> set = validator.validate(addDTO);
                    if (!set.isEmpty()) {
                        ConstraintViolation<ProjectGroupAddDTO> violation = set.stream().findFirst().get();
                        String errorMsg = "第" + (excelDTO.getRowIndex() + 1) + "行数据不合法：" + violation.getMessage();
                        throw new ConstraintViolationException(errorMsg, set);
                    }
                    return addDTO;
                })
                .collect(Collectors.toList());
        int count = projectGroupService.batchSave(list);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/template")
    public void downloadExcelTemplate(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String title = "项目集导入模板(" + DateUtil.getDateStr(new Date()) + ")";
        String fileName = URLEncoder.encode(title, "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        String[] description = new String[]{
                "模版前三行标题请勿修改",
                "带“*”号为必填项",
        };
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                // 第一行是标题，第二行是说明
                .registerWriteHandler(new TitleDescriptionWriteHandler(title, description, ProjectGroupExcelDTO.class))
                // 自定义模板单元格样式
                .registerWriteHandler(new TemplateCellStyleStrategy())
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "Sheet1")
                .head(ProjectGroupExcelDTO.class)
                // 从第三行开始写表头
                .relativeHeadRowIndex(2)
                .build();
        excelWriter.write(Arrays.asList(ProjectGroupExcelDTO.example()), writeSheet);

        excelWriter.finish();
    }

}


