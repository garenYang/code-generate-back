package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 模板目录树
 *
 * @author: cpit
 * @date: 2020/10/30
 */
public class TemplateDirTreeVO extends AbstractVO {

    @ApiModelProperty(notes = "模板id", example = "2")
    private Integer templateId;

    @ApiModelProperty(notes = "模板文件目录树")
    private List<FileNodeVO> tree;

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public List<FileNodeVO> getTree() {
        return tree;
    }

    public void setTree(List<FileNodeVO> tree) {
        this.tree = tree;
    }
}
