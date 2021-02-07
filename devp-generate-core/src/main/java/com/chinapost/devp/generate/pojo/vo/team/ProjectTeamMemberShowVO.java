package com.chinapost.devp.generate.pojo.vo.team;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.chinapost.devp.generate.pojo.example.team.ProjectTeamMemberExample.*;

/**
 * 【项目组成员】详情展示对象
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@ApiModel(description = "【项目组成员】详情展示对象")
public class ProjectTeamMemberShowVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private Integer id;

    @ApiModelProperty(notes = N_TEAM_ID, example = E_TEAM_ID)
    private Integer teamId;

    @ApiModelProperty(notes = N_USERNAME, example = E_USERNAME)
    private String username;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamId() {
        return this.teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}

