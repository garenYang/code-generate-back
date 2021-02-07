package com.chinapost.devp.generate.pojo.dto.projectgroup;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.projectgroup.ProjectGroupExample.*;

/**
 * 修改【项目集】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(description = "修改【项目集】的参数")
public class ProjectGroupUpdateDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_ID, example = E_ID, required = true)
    @NotNull
    @Length(max = 32)
    private String id;

    @ApiModelProperty(notes = N_PROJECT_GROUP_NAME, example = E_PROJECT_GROUP_NAME, required = true)
    @NotNull
    @Length(max = 255)
    private String projectGroupName;

    @ApiModelProperty(notes = N_ORDER_NO, example = E_ORDER_NO, required = true)
    @NotNull
    private Integer orderNo;



}

