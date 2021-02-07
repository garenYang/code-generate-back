package com.chinapost.devp.generate.pojo.dto;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import com.chinapost.devp.generate.constant.PatternConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

import static com.chinapost.devp.generate.pojo.example.MetaProjectExample.*;

/**
 * 新增项目DTO
 *
 * @author: cpit
 * @date: 2017/5/12
 */
@ApiModel(description = "新增项目参数")
public class MetaProjectAddDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_PROJECTGROUPID, example = E_PROJECTGROUPID)
    @NotNull
    @Length(min = 32, max = 32, message = "projectGroupId最大长度不能超过{max}")
    private String projectGroupId;

    @ApiModelProperty(notes = N_PACKAGENAME, example = E_PACKAGENAME)
    @NotNull
    @Length(min = 1, max = 100, message = "packageName最大长度不能超过{max}")
    @Pattern(regexp = PatternConst.PACKAGE_NAME, message = PatternConst.PACKAGE_NAME_MSG)
    private String packageName;

    @ApiModelProperty(notes = N_PROJECTNAME, example = E_PROJECTNAME)
    @NotNull
    @Length(min = 1, max = 50, message = "projectName最大长度不能超过{max}")
    private String projectName;

    @ApiModelProperty(notes = N_PROJECTSHORTNAME, example = E_PROJECTSHORTNAME)
    @Length(min = 1, max = 50, message = "projectShortName最大长度不能超过{max}")
    private String projectShortName;

    @ApiModelProperty(notes = N_PROJECTDESC, example = E_PROJECTDESC)
    @NotNull
    @Length(min = 1, max = 100, message = "projectDesc最大长度不能超过{max}")
    private String projectDesc;

    @ApiModelProperty(notes = N_STARTDATE, example = E_STARTDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @ApiModelProperty(notes = N_ENDDATE, example = E_ENDDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @ApiModelProperty(notes = N_GROUPID, example = E_GROUPID)
    @NotNull
    @Length(min = 1, max = 50, message = "groupId最大长度不能超过{max}")
    private String groupId;

    @ApiModelProperty(notes = N_AUTHOR, example = E_AUTHOR)
    @Length(min = 1, max = 50, message = "author最大长度不能超过{max}")
    private String author;

    @ApiModelProperty(notes = N_TEMPLATEID, example = E_TEMPLATEID)
    private Integer templateId;

    @ApiModelProperty(notes = N_TEMPLATEID, example = E_TEMPLATEID)
    private Integer templateId2;

    @ApiModelProperty(notes = N_TEMPLATEID, example = E_TEMPLATEID)
    private Integer templateId3;

    @ApiModelProperty(notes = N_REMOTE, example = E_REMOTE)
    @NotNull
    private Boolean remote;

    @ApiModelProperty(notes = N_REMOTEURL, example = E_REMOTEURL)
    @Length(max = 256, message = "remoteUrl最大长度不能超过{max}")
    private String remoteUrl;

    @ApiModelProperty(notes = N_REMOTEURL, example = E_REMOTEURL)
    @Length(max = 256, message = "remoteUrl2最大长度不能超过{max}")
    private String remoteUrl2;

    @ApiModelProperty(notes = N_REMOTEURL, example = E_REMOTEURL)
    @Length(max = 256, message = "remoteUrl3最大长度不能超过{max}")
    private String remoteUrl3;

    @ApiModelProperty(notes = N_USERNAME, example = E_USERNAME)
    @Length(max = 32, message = "username最大长度不能超过{max}")
    private String username;

    @ApiModelProperty(notes = N_PASSWORD, example = E_PASSWORD)
    @Length(max = 32, message = "password最大长度不能超过{max}")
    private String password;

    /**
     * 标签
     */
    @ApiModelProperty(notes = "标签")
    private List<LabelDTO> labels;
    /**
     * 项目特性
     */
    private MetaProjectFeatureDTO feature;

    public MetaProjectFeatureDTO getFeature() {
        return feature;
    }

    public void setFeature(MetaProjectFeatureDTO feature) {
        this.feature = feature;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Boolean getRemote() {
        return remote;
    }

    public void setRemote(Boolean remote) {
        this.remote = remote;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getTemplateId2() {
        return templateId2;
    }

    public void setTemplateId2(Integer templateId2) {
        this.templateId2 = templateId2;
    }

    public Integer getTemplateId3() {
        return templateId3;
    }

    public void setTemplateId3(Integer templateId3) {
        this.templateId3 = templateId3;
    }

    public String getRemoteUrl2() {
        return remoteUrl2;
    }

    public void setRemoteUrl2(String remoteUrl2) {
        this.remoteUrl2 = remoteUrl2;
    }

    public String getRemoteUrl3() {
        return remoteUrl3;
    }

    public void setRemoteUrl3(String remoteUrl3) {
        this.remoteUrl3 = remoteUrl3;
    }

    public List<LabelDTO> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDTO> labels) {
        this.labels = labels;
    }

    public String getProjectShortName() {
        return projectShortName;
    }

    public void setProjectShortName(String projectShortName) {
        this.projectShortName = projectShortName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectGroupId() {
        return projectGroupId;
    }

    public void setProjectGroupId(String projectGroupId) {
        this.projectGroupId = projectGroupId;
    }
}
