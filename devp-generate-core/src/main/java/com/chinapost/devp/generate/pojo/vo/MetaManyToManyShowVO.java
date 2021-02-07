package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.generate.pojo.dto.MetaMtmFeatureDTO;

/**
 * 多对多详情VO
 *
 * @author: cpit
 * @date: 2020/7/4
 */
public class MetaManyToManyShowVO extends MetaManyToManyListVO {

    private MetaMtmFeatureDTO feature;

    public MetaMtmFeatureDTO getFeature() {
        return feature;
    }

    public void setFeature(MetaMtmFeatureDTO feature) {
        this.feature = feature;
    }
}
