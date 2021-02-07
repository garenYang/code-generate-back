package com.chinapost.devp.generate.pojo.dto;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import com.chinapost.devp.common.validator.Const;
import com.chinapost.devp.generate.constant.FeatureConst;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 项目特性
 *
 * @author: cpit
 * @date: 2020/11/28
 */
public class MetaProjectFeatureDTO extends AbstractDTO {

    /**
     * spring-boot版本【1或2】
     * 不再支持spring-boot1
     */
    @ApiModelProperty(hidden = true)
    @Const(constClass = FeatureConst.Boot.class)
    @Deprecated
    private Integer bootVersion = FeatureConst.Boot.BOOT_2;

    /**
     * 启用lombok
     * 改用模板扩展属性来配置lombok
     */
    @ApiModelProperty(notes = "启用lombok", example = "false")
    @NotNull
    @Deprecated
    private Boolean lombokEnabled = false;

    @ApiModelProperty(notes = "启用redis", example = "true")
    @NotNull
    @Deprecated
    private Boolean redisEnabled = true;

    /**
     * 启用nacos注册中心
     */
    @ApiModelProperty(notes = "启用nacos注册中心", example = "false")
    @NotNull
    private Boolean nacosEnabled = false;

    /**
     * 启用nacos配置中心
     */
    @ApiModelProperty(notes = "启用nacos配置中心", example = "false")
    @NotNull
    private Boolean nacosConfigEnabled = false;

    /**
     * 是否微服务 是 1 | 否 0
     */
    @ApiModelProperty(notes = "是否微服务 是 1 | 否 0", example = "false")
    @NotNull
    private Boolean microService = false;

    /**
     * 启用spring boot admin
     */
    @ApiModelProperty(notes = "启用spring boot admin", example = "false")
    @NotNull
    private Boolean springBootAdminEnabled = true;
    /**
     * 前端框架 Vue | Angular
     */
    @ApiModelProperty(notes = "前端框架 Vue | Angular", example = "false")
    @NotNull
    private String frontEnd;
    /**
     * 是否多栏应用 tabs 是 1 | 否 0
     */
    @ApiModelProperty(notes = "栏应用 tabs 是 1 | 否 0", example = "false")
    @NotNull
    private Boolean tabs = false;
    /**
     * 前端结构    单页 one | 标签 tabs
     */
    @ApiModelProperty(notes = "前端结构    单页 one | 标签 tabs", example = "one")
    @NotNull
    private String structure;
    /**
     * 主题样式  默认样式 defualt |
     */
    @ApiModelProperty(notes = "主题样式  默认样式 defualt |", example = "defualt")
    @NotNull
    private String style;
    /**
     * 权限模块主键类型  字符串 string | 数值型 number
     */
    @ApiModelProperty(notes = "权限模块主键类型  字符串 string | 数值型 number", example = "string")
    @NotNull
    private String primaryKey;
    /**
     * 权限表删除类型  逻辑删除 1 | 物理删除 0
     */
    @ApiModelProperty(notes = "权限表删除类型  逻辑删除 1 | 物理删除 0", example = "1")
    @NotNull
    private String deleteType;
    /**
     * 逻辑正常标记值  0 1 2 3
     */
    @ApiModelProperty(notes = "逻辑正常标记值  0 1 2 3", example = "0")
    @NotNull
    private String delFlagEnable;
    /**
     * 逻辑正常标记值  0 1 2 3
     */
    @ApiModelProperty(notes = "逻辑正常标记值  0 1 2 3", example = "0")
    @NotNull
    private String delFlagDisable;
    /**
     * 是否支持机构  不支持 0 | 列表部门 1 | 树状部门 2
     */
    @ApiModelProperty(notes = "是否支持机构  不支持 0 | 列表部门 1 | 树状部门 2", example = "0")
    @NotNull
    private String dept;

    public Boolean getNacosEnabled() {
        return nacosEnabled;
    }

    public void setNacosEnabled(Boolean nacosEnabled) {
        this.nacosEnabled = nacosEnabled;
    }

    public Boolean getNacosConfigEnabled() {
        return nacosConfigEnabled;
    }

    public void setNacosConfigEnabled(Boolean nacosConfigEnabled) {
        this.nacosConfigEnabled = nacosConfigEnabled;
    }

    public Boolean getMicroService() {
        return microService;
    }

    public void setMicroService(Boolean microService) {
        this.microService = microService;
    }

    public String getFrontEnd() {
        return frontEnd;
    }

    public void setFrontEnd(String frontEnd) {
        this.frontEnd = frontEnd;
    }

    public Boolean getTabs() {
        return tabs;
    }

    public void setTabs(Boolean tabs) {
        this.tabs = tabs;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getDeleteType() {
        return deleteType;
    }

    public void setDeleteType(String deleteType) {
        this.deleteType = deleteType;
    }

    public String getDelFlagEnable() {
        return delFlagEnable;
    }

    public void setDelFlagEnable(String delFlagEnable) {
        this.delFlagEnable = delFlagEnable;
    }

    public String getDelFlagDisable() {
        return delFlagDisable;
    }

    public void setDelFlagDisable(String delFlagDisable) {
        this.delFlagDisable = delFlagDisable;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Boolean getRedisEnabled() {
        return redisEnabled;
    }

    public void setRedisEnabled(Boolean redisEnabled) {
        this.redisEnabled = redisEnabled;
    }

    public Integer getBootVersion() {
        return bootVersion;
    }

    public void setBootVersion(Integer bootVersion) {
        this.bootVersion = bootVersion;
    }

    public Boolean getLombokEnabled() {
        return lombokEnabled;
    }

    public void setLombokEnabled(Boolean lombokEnabled) {
        this.lombokEnabled = lombokEnabled;
    }

    public Boolean getSpringBootAdminEnabled() {
        return springBootAdminEnabled;
    }

    public void setSpringBootAdminEnabled(Boolean springBootAdminEnabled) {
        this.springBootAdminEnabled = springBootAdminEnabled;
    }
}
