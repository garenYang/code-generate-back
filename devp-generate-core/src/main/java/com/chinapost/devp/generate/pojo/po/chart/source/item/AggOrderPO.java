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
 * 聚合排序
 *
 * @author: cpit
 * @date: 2020-04-05
 */
public class AggOrderPO extends MetaChartSourceItemPO {

    /**
     * 排序方式
     */
    @JsonIgnore
    private Integer sortType;


    public AggOrderPO() {
        this.setType(SourceItemType.AGG_ORDER.getValue());
    }

    /**
     * 将超类转成当前类型
     *
     * @param superPO
     * @param featureDeserialize
     * @return
     */
    public static AggOrderPO fromSuperType(MetaChartSourceItemPO superPO,
                                           boolean featureDeserialize) {
        if (!SourceItemType.AGG_ORDER.getValue().equals(superPO.getType())) {
            throw new BusinessException(ErrorCode.INNER_DATA_ERROR, "类型转换异常");
        }
        AggOrderPO po = new AggOrderPO();
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
        this.sortType = featureDTO.getSortType();
    }

    @Override
    public void featureSerialize() {
        FeatureDTO featureDTO = new FeatureDTO();
        featureDTO.setSortType(this.sortType);
        this.setFeature(JsonUtil.toJSONString(featureDTO));
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    static class FeatureDTO {
        private Integer sortType;

        public Integer getSortType() {
            return sortType;
        }

        public void setSortType(Integer sortType) {
            this.sortType = sortType;
        }
    }
}
