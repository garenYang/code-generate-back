package com.chinapost.devp.generate.service;

import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.util.Base64Util;
import com.chinapost.devp.generate.pojo.po.TemplateFilePO;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 【模板文件】输出服务
 *
 * @author: cpit
 * @date: 2020/11/26
 */
@Service
public class TemplateFileOutputService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateFileOutputService.class);

    /**
     * 把文件输出到目录
     *
     * @param templateFiles 模板文件列表
     * @param outputDir     输出目录
     */
    public void outputTemplateFiles(List<TemplateFilePO> templateFiles, String outputDir) {
        File outputDirFile = new File(outputDir);
        // 如果目录存在，则删除
        if (outputDirFile.exists()) {
            try {
                FileUtils.deleteDirectory(outputDirFile);
            } catch (IOException e) {
            }
        }
        outputDirFile.mkdirs();
        try {
            for (TemplateFilePO templateFile : templateFiles) {
                String contentFilePath = outputDir + templateFile.fetchFilePath();
                File contentFile = new File(contentFilePath);
                if (templateFile.isBinaryFile()) {
                    FileUtils.writeByteArrayToFile(contentFile, Base64Util.decode(templateFile.getContent()));
                } else {
                    FileUtils.writeStringToFile(contentFile, templateFile.getContent(), StandardCharsets.UTF_8);
                }
            }
        } catch (IOException e) {
            LOGGER.error("模板文件导出异常", e);
            throw new BusinessException("模板文件导出异常");
        }
    }

}
