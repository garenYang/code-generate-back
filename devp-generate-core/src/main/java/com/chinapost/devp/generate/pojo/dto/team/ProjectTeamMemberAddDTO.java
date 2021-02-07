package com.chinapost.devp.generate.pojo.dto.team;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.team.ProjectTeamMemberExample.*;

/**
 * 新增【项目组成员】的参数
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@ApiModel(description = "新增【项目组成员】的参数")
public class ProjectTeamMemberAddDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_TEAM_ID, example = E_TEAM_ID, required = true)
    @NotNull
    private Integer teamId;

    @ApiModelProperty(notes = N_USERNAME, example = E_USERNAME, required = true)
    @NotNull
    @Length(max = 1000)
    private String username;


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


