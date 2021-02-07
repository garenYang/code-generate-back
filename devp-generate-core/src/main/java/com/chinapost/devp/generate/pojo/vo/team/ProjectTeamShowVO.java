package com.chinapost.devp.generate.pojo.vo.team;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.chinapost.devp.generate.pojo.example.team.ProjectTeamExample.*;

/**
 * 【项目组】详情展示对象
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@ApiModel(description = "【项目组】详情展示对象")
public class ProjectTeamShowVO extends AbstractVO {

    @ApiModelProperty(notes = N_TEAM_ID, example = E_TEAM_ID)
    private Integer teamId;

    @ApiModelProperty(notes = N_NAME, example = E_NAME)
    private String name;


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


}

