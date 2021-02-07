package com.chinapost.devp.generate.pojo.dto.chart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author yanglong
 * date 2021-02-01
 */
@ApiModel(description = "修改【树表】入参")
public class TreeUpdateDTO extends TreeAddDTO {

    @ApiModelProperty(notes = "主键ID", example = "1", required = true)
    @NotNull
    private Integer sourceItemId;

    public Integer getSourceItemId() {
        return sourceItemId;
    }

    public void setSourceItemId(Integer sourceItemId) {
        this.sourceItemId = sourceItemId;
    }
}
