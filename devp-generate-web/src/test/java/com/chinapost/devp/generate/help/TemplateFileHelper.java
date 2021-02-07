package com.chinapost.devp.generate.help;

import com.chinapost.devp.common.util.SafeUtil;
import com.chinapost.devp.generate.pojo.dto.TemplateFileAddDTO;
import com.chinapost.devp.generate.pojo.dto.TemplateFileUpdateDTO;
import com.chinapost.devp.generate.pojo.po.TemplateFilePO;
import com.chinapost.devp.generate.service.TemplateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.chinapost.devp.generate.pojo.example.TemplateFileExample.*;

@Component
public class TemplateFileHelper {

    @Autowired
    private TemplateFileService templateFileService;

    /**
     * 生成add测试数据
     *
     * @return
     */
    public TemplateFileAddDTO getTemplateFileAddDTO(Integer templateId) {
        TemplateFileAddDTO dto = new TemplateFileAddDTO();
        dto.setFileName(E_FILE_NAME);
        dto.setFileDir(E_FILE_DIR);
        dto.setTemplateId(templateId);
        dto.setContextType(SafeUtil.getInteger(E_CONTEXT_TYPE));
        dto.setFileType(SafeUtil.getInteger(E_FILE_TYPE));
        return dto;
    }


    /**
     * 生成update测试数据
     *
     * @return
     */
    public TemplateFileUpdateDTO getTemplateFileUpdateDTO(TemplateFilePO templateFile) {
        TemplateFileUpdateDTO dto = new TemplateFileUpdateDTO();
        dto.setFileId(templateFile.getFileId());
        dto.setFileName(templateFile.getFileName());
        dto.setFileDir(templateFile.getFileDir());
        dto.setTemplateId(templateFile.getTemplateId());
        dto.setContextType(templateFile.getContextType());
        dto.setFileType(templateFile.getFileType());
        return dto;
    }

    /**
     * 保存示例
     *
     * @return
     */
    public TemplateFilePO saveTemplateFileExample(Integer templateId) {
        TemplateFileAddDTO addDTO = this.getTemplateFileAddDTO(templateId);
        return templateFileService.save(addDTO);
    }


}

