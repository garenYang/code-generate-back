package com.chinapost.devp.generate.pojo.vo.team;

import com.chinapost.devp.common.constant.JsonFieldConst;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import static com.chinapost.devp.generate.pojo.example.team.ProjectTeamExample.*;

/**
 * 【项目组】列表展示对象
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@ApiModel(description = "【项目组】列表展示对象")
public class ProjectTeamListVO extends AbstractVO {

    @ApiModelProperty(notes = N_TEAM_ID, example = E_TEAM_ID)
    private Integer teamId;

    @ApiModelProperty(notes = N_NAME, example = E_NAME)
    private String name;

    @ApiModelProperty(notes = N_CREATED_TIME, example = E_CREATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date createdTime;

    @ApiModelProperty(notes = N_OPERATED_TIME, example = E_OPERATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private Date operatedTime;


    public Integer getTeamId() {
        return this.teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getOperatedTime() {
        return this.operatedTime;
    }

    public void setOperatedTime(Date operatedTime) {
        this.operatedTime = operatedTime;
    }


}

