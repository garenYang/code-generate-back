package com.chinapost.devp.generate.pojo.dto.team;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.team.ProjectTeamExample.E_NAME;
import static com.chinapost.devp.generate.pojo.example.team.ProjectTeamExample.N_NAME;

/**
 * 新增【项目组】的参数
 *
 * @author: cpit
 * @date: 2020/11/23
 */
@ApiModel(description = "新增【项目组】的参数")
public class ProjectTeamAddDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_NAME, example = E_NAME, required = true)
    @NotNull
    @Length(max = 32)
    private String name;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


