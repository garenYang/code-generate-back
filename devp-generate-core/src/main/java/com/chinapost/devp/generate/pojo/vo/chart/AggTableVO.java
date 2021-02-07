package com.chinapost.devp.generate.pojo.vo.chart;

import com.chinapost.devp.generate.pojo.dto.chart.ChartItemDTO;

import java.util.List;

/**
 * 聚合表
 *
 * @author: cpit
 * @date: 2020-05-05
 */
public class AggTableVO extends MetaChartShowVO {

    /**
     * 维度列
     */
    private List<ChartItemDTO> dimensionList;

    /**
     * 指标列
     */
    private List<ChartItemDTO> metricsList;

    /**
     * 默认每页记录数
     */
    private Integer defaultPageSize;
    /**
     * 是否支持excel导出
     */
    private Boolean excelExport;

    public Boolean getExcelExport() {
        return excelExport;
    }

    public void setExcelExport(Boolean excelExport) {
        this.excelExport = excelExport;
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
}
