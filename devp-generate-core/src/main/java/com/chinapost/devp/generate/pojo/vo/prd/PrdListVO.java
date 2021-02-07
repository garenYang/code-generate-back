package com.chinapost.devp.generate.pojo.vo.prd;

import com.chinapost.devp.common.constant.JsonFieldConst;
import com.chinapost.devp.common.pojo.vo.AbstractVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

import static com.chinapost.devp.generate.pojo.example.prd.PrdExample.*;

/**
 * 【需求文档管理】列表展示对象
 *
 * @author wn
 * @date 2021/01/22
 */
@Data
@ApiModel(description = "【需求文档管理】列表展示对象")
public class PrdListVO extends AbstractVO {

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

    @ApiModelProperty(notes = N_CREATED_TIME, example = E_CREATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private LocalDateTime createdTime;

    @ApiModelProperty(notes = N_OPERATED_TIME, example = E_OPERATED_TIME)
    @JsonFormat(pattern = JsonFieldConst.DEFAULT_DATETIME_FORMAT, timezone = "GMT+8")
    private LocalDateTime operatedTime;


}

