package com.chinapost.devp.generate.pojo.dto.chart.source.item;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author yanglong
 * date 2021-02-01
 */
@ApiModel(description = "修改【树】入参")
public class NodeUpdateDTO extends NodeAddDTO {
    @ApiModelProperty(notes = "主键ID", example = "1", required = true)
    private Integer sourceItemId;

    public Integer getSourceItemId() {
        return sourceItemId;
    }

    public void setSourceItemId(Integer sourceItemId) {
        this.sourceItemId = sourceItemId;
    }
}
