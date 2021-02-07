package com.chinapost.devp.generate.pojo.dto;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import com.chinapost.devp.common.xss.IgnoreXSS;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.TemplateFileExample.*;

/**
 * 修改【模板文件内容】的参数
 *
 * @author: cpit
 * @date: 2020/10/24
 */
@ApiModel(description = "修改【模板文件内容】的参数")
public class TemplateFileContentUpdateDTO extends AbstractDTO {

    @ApiModelProperty(hidden = true)
    private Integer fileId;

    @ApiModelProperty(notes = N_VERSION, example = E_VERSION)
    @NotNull
    private Integer version;

    @ApiModelProperty(notes = N_CONTENT, example = E_CONTENT)
    @IgnoreXSS
    private String content;

    public Integer getFileId() {
        return this.fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

