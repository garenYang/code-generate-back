package com.chinapost.devp.generate.pojo.po.chart.source.item;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.common.util.JsonUtil;
import com.chinapost.devp.generate.constant.SourceItemType;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartSourceItemMapper;
import com.chinapost.devp.generate.pojo.po.chart.source.MetaChartSourcePO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Map;

/**
 * having条件
 *
 * @author: cpit
 * @date: 2020-04-05
 */
public class HavingPO extends MetaChartSourceItemPO {

    /**
     * 过滤运算符
     */
    @JsonIgnore
    private Integer filterOperator;

    /**
     * 过滤值
     */
    @JsonIgnore
    private String[] filterValue;

    public HavingPO() {
        this.setType(SourceItemType.HAVING.getValue());
    }

    /**
     * 将超类转成当前类型
     *
     * @param superPO
     * @param featureDeserialize
     * @return
     */
    public static HavingPO fromSuperType(MetaChartSourceItemPO superPO,
                                         boolean featureDeserialize) {
        if (!SourceItemType.HAVING.getValue().equals(superPO.getType())) {
            throw new BusinessException(ErrorCode.INNER_DATA_ERROR, "类型转换异常");
        }
        HavingPO po = new HavingPO();
        MetaChartSourceItemMapper.INSTANCE.copyProperties(po, superPO);
        if (featureDeserialize) {
            po.featureDeserialize();
        }
        return po;
    }

    @Override
    public void assembleItem(MetaChartSourcePO chartSource) {
        super.assembleItem(chartSource);
        Map<Integer, MetricsPO> metricsMap = chartSource.getMetricsMap();
        metricsMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(this.getParentId()))
                .findFirst()
                .ifPresent(entry -> this.setParent(entry.getValue()));
    }

    @Override
    public void featureDeserialize() {
        FeatureDTO featureDTO = JsonUtil.parseObject(this.getFeature(), FeatureDTO.class);
        this.filterOperator = featureDTO.getFilterOperator();
        this.filterValue = featureDTO.getFilterValue();
    }

    @Override
    public void featureSerialize() {
        FeatureDTO featureDTO = new FeatureDTO();
        featureDTO.setFilterOperator(this.filterOperator);
        featureDTO.setFilterValue(this.filterValue);
        this.setFeature(JsonUtil.toJSONString(featureDTO));
    }

    public Integer getFilterOperator() {
        return filterOperator;
    }

    public void setFilterOperator(Integer filterOperator) {
        this.filterOperator = filterOperator;
    }

    public String[] getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String[] filterValue) {
        this.filterValue = filterValue;
    }

    static class FeatureDTO {
        private Integer filterOperator;
        private String[] filterValue;

        public Integer getFilterOperator() {
            return filterOperator;
        }

        public void setFilterOperator(Integer filterOperator) {
            this.filterOperator = filterOperator;
        }

        public String[] getFilterValue() {
            return filterValue;
        }

        public void setFilterValue(String[] filterValue) {
            this.filterValue = filterValue;
        }
    }
}
