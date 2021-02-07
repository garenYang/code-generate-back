package com.chinapost.devp.generate.pojo.vo.chart.source.item;

/**
 * 维度
 *
 * @author: cpit
 * @date: 2020-05-05
 */
public class DimensionVO extends MetaChartSourceItemVO {

    /**
     * 字段id
     */
    private Integer fieldId;

    /**
     * 维度粒度
     */
    private Integer granularity;

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getGranularity() {
        return granularity;
    }

    public void setGranularity(Integer granularity) {
        this.granularity = granularity;
    }
}
