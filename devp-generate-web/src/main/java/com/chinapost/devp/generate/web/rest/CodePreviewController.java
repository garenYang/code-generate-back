package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.po.CodeTemplatePO;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.qo.CodeContentQO;
import com.chinapost.devp.generate.pojo.vo.CodeTreeVO;
import com.chinapost.devp.generate.pojo.vo.FileNodeVO;
import com.chinapost.devp.generate.service.CodeTemplateService;
import com.chinapost.devp.generate.service.DataDirService;
import com.chinapost.devp.generate.service.MetaProjectService;
import com.chinapost.devp.generate.util.FileNodeUtil;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.CodePreviewAPI;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 【代码预览】控制器
 *
 * @author: cpit
 * @date: 2020/8/29
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/code_preview")
public class CodePreviewController extends AbstractController implements CodePreviewAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodePreviewController.class);
    @Autowired
    private MetaProjectService metaProjectService;
    @Autowired
    private CodeTemplateService codeTemplateService;
    @Autowired
    private DataDirService dataDirService;


    @Override
    @GetMapping(value = "/file_content", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity<String> getFileContent(@Valid CodeContentQO qo) {
        MetaProjectPO project = metaProjectService.getAndCheckProject(qo.getProjectId());
        if (project.getProjectVersion() < qo.getProjectVersion()) {
            throw new BusinessException("projectVersion有误");
        }

        CodeTemplatePO templatePO = codeTemplateService.getCodeTemplate(qo.getTemplateId(), true);
        if (templatePO.getInnerVersion() < qo.getTemplateInnerVersion()) {
            throw new BusinessException("模板已更新，请返回重试");
        }

        String projectDir = dataDirService.getProjectRecentDir(project, templatePO);
        File dirFile = new File(projectDir);
        if (!dirFile.exists()) {
            throw new BusinessException("代码目录不存在");
        }
        File file = new File(dirFile, qo.getFilePath());
        if (!file.exists()) {
            LOGGER.error("文件不存在:{}", file.getPath());
            throw new BusinessException("文件不存在");
        }
        try {
            if (!FileUtils.directoryContains(dirFile, file)) {
                throw new BusinessException("文件路径不合法");
            }
        } catch (IOException e) {
            LOGGER.error("文件路径不合法", e);
            throw new BusinessException("文件路径不合法");
        }
        if (file.isDirectory()) {
            throw new BusinessException("文件不合法");
        }
        if (file.isHidden()) {
            throw new BusinessException("隐藏文件不显示");
        }
        try {
            String content = FileUtils.readFileToString(file, "utf-8");
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            LOGGER.error("读取文件异常", e);
            throw new BusinessException("读取文件异常");
        }
    }

    @Override
    @GetMapping(value = "/code_tree")
    @ResponseBody
    public ResponseEntity<CodeTreeVO> codeTree(@RequestParam Integer projectId,
                                               @RequestParam Integer templateId) {
        MetaProjectPO project = metaProjectService.getAndCheckProject(projectId);
        CodeTemplatePO templatePO = codeTemplateService.getCodeTemplate(templateId, true);
        String projectDir = dataDirService.getProjectRecentDir(project, templatePO);
        File dirFile = new File(projectDir);
        if (!dirFile.exists()) {
            throw new BusinessException("代码目录不存在，请返回重试");
        }
        List<FileNodeVO> fileNodeList = FileNodeUtil.recurFileNodeTree(dirFile, dirFile);
        CodeTreeVO treeVO = new CodeTreeVO();
        treeVO.setProjectId(projectId);
        treeVO.setProjectVersion(project.getProjectVersion());
        treeVO.setTree(fileNodeList);
        treeVO.setTemplateId(templateId);
        treeVO.setTemplateInnerVersion(templatePO.getInnerVersion());
        return ResponseEntity.ok(treeVO);
    }


}
