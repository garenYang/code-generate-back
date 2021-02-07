package com.chinapost.devp.generate.pojo.dto.chart;

import com.chinapost.devp.generate.constant.ChartType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 新增【聚合表】入参
 *
 * @author: cpit
 * @date: 2020-04-05
 */
@ApiModel(description = "新增【聚合表】入参")
public class AggTableAddDTO extends AbstractChartDTO {

    @ApiModelProperty(notes = "维度列")
    private List<ChartItemDTO> dimensionList;

    @ApiModelProperty(notes = "指标列")
    private List<ChartItemDTO> metricsList;

    @ApiModelProperty(notes = "默认每页记录数")
    private Integer defaultPageSize;

    @ApiModelProperty(notes = "是否支持excel导出")
    private Boolean excelExport;

    @Override
    public Integer getChartType() {
        return ChartType.AGG_TABLE.getValue();
    }

    public Integer getDefaultPageSize() {
        return defaultPageSize;
    }

    public void setDefaultPageSize(Integer defaultPageSize) {
        this.defaultPageSize = defaultPageSize;
    }

    public List<ChartItemDTO> getDimensionList() {
        return dimensionList;
    }

    public void setDimensionList(List<ChartItemDTO> dimensionList) {
        this.dimensionList = dimensionList;
    }

    public List<ChartItemDTO> getMetricsList() {
        return metricsList;
    }

    public void setMetricsList(List<ChartItemDTO> metricsList) {
        this.metricsList = metricsList;
    }

    public Boolean getExcelExport() {
        return excelExport;
    }

    public void setExcelExport(Boolean excelExport) {
        this.excelExport = excelExport;
    }
}
