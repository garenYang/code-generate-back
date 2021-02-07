package com.chinapost.devp.generate.pojo.po.chart;

import com.chinapost.devp.common.constant.ErrorCode;
import com.chinapost.devp.common.exception.BusinessException;
import com.chinapost.devp.generate.constant.ChartType;
import com.chinapost.devp.generate.pojo.mapper.chart.MetaChartMapper;

/**
 * @author yanglong
 * date 2021-02-01
 */
public class TreePO extends MetaChartPO {

    /**
     * 将超类转成当前类型
     *
     * @param superPO
     * @param featureDeserialize
     * @return
     */
    public static TreePO fromSuperType(MetaChartPO superPO,
                                      boolean featureDeserialize) {
        if (!ChartType.TREE.getValue().equals(superPO.getChartType())) {
            throw new BusinessException(ErrorCode.INNER_DATA_ERROR, "类型转换异常");
        }
        TreePO po = new TreePO();
        MetaChartMapper.INSTANCE.copyProperties(po, superPO);
        if (featureDeserialize) {
            po.featureDeserialize();
        }
        return po;
    }
}
