package com.chinapost.devp.generate.pojo.po;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 级联扩展
 * <p>从外键字段对应的表中级联查出要展示的字段
 *
 * @author: cpit
 * @date: 2020/5/28
 */
public class MetaCascadeExtPO extends BasePO {

    /**
     * 主键id
     */
    private Integer cascadeExtId;
    /**
     * 所属项目id
     */
    private Integer projectId;
    /**
     * 所属字段id
     */
    private Integer fieldId;
    /**
     * 所属实体id
     */
    private Integer entityId;
    /**
     * 展示字段别名
     */
    private String alias;
    /**
     * 是否在列表中展示
     */
    private Boolean list;
    /**
     * 是否在详情中展示
     */
    private Boolean show;
    /**
     * 是否为列表查询条件
     */
    private Boolean query;
    /**
     * 级联实体的id
     */
    private Integer cascadeEntityId;
    /**
     * 级联展示字段的id
     */
    private Integer cascadeFieldId;
    /**
     * 级联字段
     */
    @JsonIgnore
    private transient MetaFieldPO cascadeField;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public MetaFieldPO getCascadeField() {
        return cascadeField;
    }

    public void setCascadeField(MetaFieldPO cascadeField) {
        this.cascadeField = cascadeField;
    }

    public Integer getCascadeExtId() {
        return cascadeExtId;
    }

    public void setCascadeExtId(Integer cascadeExtId) {
        this.cascadeExtId = cascadeExtId;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public Boolean getQuery() {
        return query;
    }

    public void setQuery(Boolean query) {
        this.query = query;
    }

    public Integer getCascadeEntityId() {
        return cascadeEntityId;
    }

    public void setCascadeEntityId(Integer cascadeEntityId) {
        this.cascadeEntityId = cascadeEntityId;
    }

    public Integer getCascadeFieldId() {
        return cascadeFieldId;
    }

    public void setCascadeFieldId(Integer cascadeFieldId) {
        this.cascadeFieldId = cascadeFieldId;
    }

}
