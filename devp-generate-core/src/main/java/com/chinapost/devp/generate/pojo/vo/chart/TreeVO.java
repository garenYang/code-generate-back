package com.chinapost.devp.generate.pojo.vo.chart;

import com.chinapost.devp.generate.pojo.dto.chart.ChartItemDTO;
import com.chinapost.devp.generate.pojo.vo.chart.MetaChartShowVO;

/**
 * 饼图
 *
 * @author: cpit
 * @date: 2020-05-05
 */
public class TreeVO extends MetaChartShowVO {

    /**
     * 维度项
     */
    private ChartItemDTO dimension;

    /**
     * 指标项
     */
    private ChartItemDTO metrics;

    /**
     * 图表配置项模板
     */
    private String optionTemplate;

    public ChartItemDTO getDimension() {
        return dimension;
    }

    public void setDimension(ChartItemDTO dimension) {
        this.dimension = dimension;
    }

    public ChartItemDTO getMetrics() {
        return metrics;
    }

    public void setMetrics(ChartItemDTO metrics) {
        this.metrics = metrics;
    }

    public String getOptionTemplate() {
        return optionTemplate;
    }

    public void setOptionTemplate(String optionTemplate) {
        this.optionTemplate = optionTemplate;
    }
}
