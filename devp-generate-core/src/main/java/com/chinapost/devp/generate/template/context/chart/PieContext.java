package com.chinapost.devp.generate.template.context.chart;

import com.chinapost.devp.generate.pojo.dto.chart.ChartItemDTO;
import com.chinapost.devp.generate.pojo.po.MetaProjectPO;
import com.chinapost.devp.generate.pojo.po.chart.PiePO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.DimensionPO;
import com.chinapost.devp.generate.pojo.po.chart.source.item.MetricsPO;

/**
 * 饼图上下文对象
 *
 * @author: cpit
 * @date: 2020-04-12
 */
public class PieContext extends AbstractChartContext<PiePO> {

    /**
     * 维度项
     */
    private final ChartItemDTO<DimensionPO> dimension;

    /**
     * 指标项
     */
    private final ChartItemDTO<MetricsPO> metrics;

    /**
     * 图表配置项模板
     */
    private final String optionTemplate;

    public PieContext(MetaProjectPO project, PiePO pie) {
        super(project, pie);
        this.dimension = pie.getDimension();
        this.metrics = pie.getMetrics();
        this.optionTemplate = pie.getOptionTemplate();
    }

    public ChartItemDTO<DimensionPO> getDimension() {
        return dimension;
    }

    public ChartItemDTO<MetricsPO> getMetrics() {
        return metrics;
    }

    public String getOptionTemplate() {
        return optionTemplate;
    }

}
