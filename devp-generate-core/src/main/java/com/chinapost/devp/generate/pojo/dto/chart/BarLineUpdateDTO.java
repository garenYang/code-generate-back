package com.chinapost.devp.generate.pojo.dto.chart;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 修改【柱线图】入参
 *
 * @author: cpit
 * @date: 2020-04-05
 */
@ApiModel(description = "修改【柱线图】入参")
public class BarLineUpdateDTO extends BarLineAddDTO {

    @ApiModelProperty(notes = "图表主键", example = "1", required = true)
    @NotNull
    private Integer chartId;

    public Integer getChartId() {
        return chartId;
    }

    public void setChartId(Integer chartId) {
        this.chartId = chartId;
    }
}
