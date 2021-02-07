package com.chinapost.devp.generate.pojo.qo.team;

import com.chinapost.devp.common.pojo.qo.AbstractQO;
import io.swagger.annotations.ApiParam;

import static com.chinapost.devp.generate.pojo.example.team.ProjectTeamMemberExample.E_TEAM_ID;
import static com.chinapost.devp.generate.pojo.example.team.ProjectTeamMemberExample.N_TEAM_ID;

/**
 * 查询【项目组成员】的参数
 *
 * @author: cpit
 * @date: 2020/11/23
 */
public class ProjectTeamMemberQO extends AbstractQO {

    @ApiParam(value = N_TEAM_ID, example = E_TEAM_ID)
    private Integer teamId;

    @ApiParam(value = "创建时间排序标识【1升序,-1降序,0不排序】", example = "1")
    private Integer createdTimeSortSign;


    public Integer getTeamId() {
        return this.teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getCreatedTimeSortSign() {
        return this.createdTimeSortSign;
    }

    public void setCreatedTimeSortSign(Integer createdTimeSortSign) {
        this.createdTimeSortSign = createdTimeSortSign;
    }

}

