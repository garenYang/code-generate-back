package com.chinapost.devp.generate.pojo.vo.chart;

import com.chinapost.devp.generate.pojo.dto.chart.ChartItemDTO;

import java.util.List;

/**
 * 柱线图
 *
 * @author: cpit
 * @date: 2020-05-05
 */
public class BarLineVO extends MetaChartShowVO {

    /**
     * 主X轴
     */
    private ChartItemDTO axisX;

    /**
     * 副X轴
     */
    private ChartItemDTO axisX2;

    /**
     * Y轴
     */
    private List<ChartItemDTO> axisYList;

    /**
     * 图表配置项模板
     */
    private String optionTemplate;

    public ChartItemDTO getAxisX() {
        return axisX;
    }

    public void setAxisX(ChartItemDTO axisX) {
        this.axisX = axisX;
    }

    public ChartItemDTO getAxisX2() {
        return axisX2;
    }

    public void setAxisX2(ChartItemDTO axisX2) {
        this.axisX2 = axisX2;
    }

    public List<ChartItemDTO> getAxisYList() {
        return axisYList;
    }

    public void setAxisYList(List<ChartItemDTO> axisYList) {
        this.axisYList = axisYList;
    }

    public String getOptionTemplate() {
        return optionTemplate;
    }

    public void setOptionTemplate(String optionTemplate) {
        this.optionTemplate = optionTemplate;
    }
}
