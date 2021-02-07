package com.chinapost.devp.generate.pojo.dto;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体特性
 *
 * @author: cpit
 * @date: 2020/9/30
 */
public class MetaEntityFeatureDTO extends AbstractDTO {

    /**
     * 是否生成save方法
     */
    @ApiModelProperty(notes = "是否生成save方法", example = "true")
    private Boolean save = true;
    /**
     * 是否生成update方法
     */
    @ApiModelProperty(notes = "是否生成update方法", example = "true")
    private Boolean update = true;
    /**
     * 是否生成delete方法
     */
    @ApiModelProperty(notes = "是否生成delete方法", example = "true")
    private Boolean delete = true;
    /**
     * 是否生成deleteBatch方法
     */
    @ApiModelProperty(notes = "是否生成deleteBatch方法", example = "true")
    private Boolean deleteBatch = true;
    /**
     * 是否生成list方法
     */
    @ApiModelProperty(notes = "是否生成list方法", example = "true")
    private Boolean list = true;
    /**
     * 是否生成show方法
     */
    @ApiModelProperty(notes = "是否生成show方法", example = "true")
    private Boolean show = true;
    /**
     * 实体内的标题字段
     * 用于在java模板内生成findOptions服务
     */
    @ApiModelProperty(notes = "实体内的标题字段", example = "1")
    private Integer titleFieldId;
    /**
     * 是否生成excel导出方法
     */
    @ApiModelProperty(notes = "是否生成excel导出方法", example = "false")
    private Boolean excelExport = false;
    /**
     * 是否生成excel导入方法
     */
    @ApiModelProperty(notes = "是否生成excel导入方法", example = "false")
    private Boolean excelImport = false;


    public Boolean getSave() {
        return save;
    }

    public void setSave(Boolean save) {
        this.save = save;
    }

    public Boolean getUpdate() {
        return update;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Boolean getDeleteBatch() {
        return deleteBatch;
    }

    public void setDeleteBatch(Boolean deleteBatch) {
        this.deleteBatch = deleteBatch;
    }

    public Boolean getList() {
        return list;
    }

    public void setList(Boolean list) {
        this.list = list;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public Integer getTitleFieldId() {
        return titleFieldId;
    }

    public void setTitleFieldId(Integer titleFieldId) {
        this.titleFieldId = titleFieldId;
    }

    public Boolean getExcelExport() {
        return excelExport;
    }

    public void setExcelExport(Boolean excelExport) {
        this.excelExport = excelExport;
    }

    public Boolean getExcelImport() {
        return excelImport;
    }

    public void setExcelImport(Boolean excelImport) {
        this.excelImport = excelImport;
    }
}
