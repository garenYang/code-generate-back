package com.chinapost.devp.generate.pojo.vo.prd;

import com.chinapost.devp.common.pojo.vo.AbstractVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import static com.chinapost.devp.generate.pojo.example.prd.PrdExample.*;

/**
 * 【需求文档管理】详情展示对象
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@ApiModel(description = "【需求文档管理】详情展示对象")
public class PrdShowVO extends AbstractVO {

    @ApiModelProperty(notes = N_ID, example = E_ID)
    private String id;

    @ApiModelProperty(notes = N_PROJECT_GROUP_ID, example = N_PROJECT_GROUP_ID)
    private String projectGroupId;

    @ApiModelProperty(notes = N_PARENT_ID, example = E_PARENT_ID)
    private String parentId;

    @ApiModelProperty(notes = N_PARENT_IDS, example = E_PARENT_IDS)
    private String parentIds;

    @ApiModelProperty(notes = N_TITLE, example = E_TITLE)
    private String title;

    @ApiModelProperty(notes = N_LEAF, example = E_LEAF)
    private Integer leaf;

    @ApiModelProperty(notes = N_SORT, example = E_SORT)
    private Integer sort;

    @ApiModelProperty(notes = N_CONTENT, example = E_CONTENT)
    private String content;


}

