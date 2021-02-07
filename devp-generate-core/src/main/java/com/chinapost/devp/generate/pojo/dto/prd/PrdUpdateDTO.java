package com.chinapost.devp.generate.pojo.dto.prd;

import com.chinapost.devp.common.pojo.dto.AbstractDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import static com.chinapost.devp.generate.pojo.example.prd.PrdExample.*;

/**
 * 修改【需求文档管理】的参数
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@ApiModel(description = "修改【需求文档管理】的参数")
public class PrdUpdateDTO extends AbstractDTO {

    @ApiModelProperty(notes = N_ID, example = E_ID, required = true)
    @NotNull
    @Length(max = 32)
    private String id;

    @ApiModelProperty(notes = N_PROJECT_GROUP_ID, example = N_PROJECT_GROUP_ID, required = true)
    @NotNull
    private String projectGroupId;

    @ApiModelProperty(notes = N_PARENT_ID, example = E_PARENT_ID, required = true)
    @NotNull
    @Length(max = 32)
    private String parentId;

    @ApiModelProperty(notes = N_PARENT_IDS, example = E_PARENT_IDS)
    @Length(max = 2000)
    private String parentIds;

    @ApiModelProperty(notes = N_TITLE, example = E_TITLE, required = true)
    @NotNull
    @Length(max = 200)
    private String title;

    @ApiModelProperty(notes = N_LEAF, example = E_LEAF, required = true)
    private Integer leaf;

    @ApiModelProperty(notes = N_SORT, example = E_SORT, required = true)
    @NotNull
    private Integer sort;

    @ApiModelProperty(notes = N_CONTENT, example = E_CONTENT)
    @Length(max = 2000)
    private String content;


}

