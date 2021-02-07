package com.chinapost.devp.generate.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import com.chinapost.devp.generate.pojo.dto.LabelDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

import static com.chinapost.devp.generate.pojo.example.MetaProjectExample.*;

/**
 * 项目列表展示对象
 *
 * @author: cpit
 * @date 2017/5/24
 */
@Data
public class MetaProjectListVO extends AbstractVO {

    @ApiModelProperty(notes = N_PROJECTID, example = E_PROJECTID)
    private Integer projectId;

    @ApiModelProperty(notes = N_PROJECTGROUPID, example = E_PROJECTGROUPID)
    @JSONField(name = "projectGroupId")
    private String projectGroupId;

    @ApiModelProperty(notes = N_PROJECTGROUPNAME, example = E_PROJECTGROUPNAME)
    @JSONField(name = "projectGroupName")
    private String projectGroupName;

    @ApiModelProperty(notes = N_PACKAGENAME, example = E_PACKAGENAME)
    private String packageName;

    @ApiModelProperty(notes = N_PROJECTNAME, example = E_PROJECTNAME)
    private String projectName;

    @ApiModelProperty(notes = N_PROJECTSHORTNAME, example = E_PROJECTSHORTNAME)
    private String projectShortName;

    @ApiModelProperty(notes = N_PROJECTDESC, example = E_PROJECTDESC)
    private String projectDesc;

    @ApiModelProperty(notes = N_STARTDATE, example = E_STARTDATE)
    private Date startDate;

    @ApiModelProperty(notes = N_ENDDATE, example = E_ENDDATE)
    private Date endDate;

    @ApiModelProperty(notes = N_GROUPID, example = E_GROUPID)
    private String groupId;

    @ApiModelProperty(notes = N_AUTHOR, example = E_AUTHOR)
    private String author;

    @ApiModelProperty(notes = N_REMOTE, example = E_REMOTE)
    private Boolean remote;

    @ApiModelProperty(notes = N_TEMPLATEID, example = E_TEMPLATEID)
    private Integer templateId;

    @ApiModelProperty(notes = N_TEMPLATEID, example = E_TEMPLATEID)
    private Integer templateId2;

    @ApiModelProperty(notes = N_TEMPLATEID, example = E_TEMPLATEID)
    private Integer templateId3;

    @ApiModelProperty(notes = N_REMOTEURL, example = E_REMOTEURL)
    private String remoteUrl;

    @ApiModelProperty(notes = N_REMOTEURL, example = E_REMOTEURL)
    private String remoteUrl2;

    @ApiModelProperty(notes = N_REMOTEURL, example = E_REMOTEURL)
    private String remoteUrl3;

    @ApiModelProperty(notes = N_USERNAME, example = E_USERNAME)
    private String username;

    @ApiModelProperty(notes = "标签")
    private List<LabelDTO> labels;

    @ApiModelProperty(notes = N_TEAM_ID, example = E_TEAM_ID)
    private Integer teamId;

    @ApiModelProperty(notes = N_CREATEDBY, example = E_CREATEDBY)
    private String createdBy;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("projectId", projectId)
                .append("packageName", packageName)
                .append("projectName", projectName)
                .append("projectDesc", projectDesc)
                .append("groupId", groupId)
                .append("author", author)
                .append("remote", remote)
                .toString();
    }

}
