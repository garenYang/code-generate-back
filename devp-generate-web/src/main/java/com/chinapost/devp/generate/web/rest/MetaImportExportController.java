package com.chinapost.devp.generate.web.rest;

import com.chinapost.devp.generate.constant.WebConst;
import com.chinapost.devp.generate.pojo.mapper.MetaProjectMapper;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.vo.MetaProjectShowVO;
import com.chinapost.devp.generate.service.DataDirService;
import com.chinapost.devp.generate.service.MetaExportService;
import com.chinapost.devp.generate.service.MetaImportService;
import com.chinapost.devp.generate.service.MetaProjectService;
import com.chinapost.devp.generate.web.AbstractController;
import com.chinapost.devp.generate.web.api.MetaImportExportAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URI;

/**
 * 元数据导入导出controller
 *
 * @author: cpit
 * @date: 2020/11/26
 */
@RestController
@RequestMapping(WebConst.API_PATH)
public class MetaImportExportController extends AbstractController implements MetaImportExportAPI {

    @Autowired
    private MetaImportService metaImportService;
    @Autowired
    private MetaExportService metaExportService;
    @Autowired
    private MetaProjectService metaProjectService;
    @Autowired
    private DataDirService dataDirService;

    @Override
    @GetMapping(value = "/meta_export/{projectId}")
    public void metaExport(@PathVariable Integer projectId, HttpServletResponse response) {
        File zipFile = metaExportService.metaExport(projectId);
        if (zipFile == null || !zipFile.exists()) {
            this.replyNotFound(response);
        } else {
            String normalProjectName = metaProjectService.getNormalProjectName(projectId);
            String downloadFileName = normalProjectName + "Export.zip";
            this.replyDownloadFile(response, zipFile, downloadFileName);
        }
    }

    @Override
    @PostMapping(value = "/meta_import")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MetaProjectShowVO> metaImport(@RequestParam(value = "file") MultipartFile file) throws Exception {
        String importFilePath = dataDirService.getProjectImportFilePath();
        File zipFile = new File(importFilePath);
        File parentFile = zipFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        file.transferTo(zipFile);
        MetaProjectPO metaProjectPO = metaImportService.metaImport(zipFile);
        return ResponseEntity.created(new URI(apiPath + "/meta_project/" + metaProjectPO.getProjectId()))
            .body(MetaProjectMapper.INSTANCE.toShowVO(metaProjectPO));
    }


}
