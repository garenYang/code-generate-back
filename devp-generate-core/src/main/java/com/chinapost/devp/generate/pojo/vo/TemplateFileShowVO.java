package com.chinapost.devp.generate.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.chinapost.devp.generate.pojo.example.TemplateFileExample.E_CONTENT;
import static com.chinapost.devp.generate.pojo.example.TemplateFileExample.N_CONTENT;

/**
 * 【模板文件】详情展示对象
 *
 * @author: cpit
 * @date: 2020/10/24
 */
@ApiModel(description = "【模板文件】详情展示对象")
public class TemplateFileShowVO extends TemplateFileListVO {

    @ApiModelProperty(notes = N_CONTENT, example = E_CONTENT)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

