package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.generate.pojo.dto.MetaEntityFeatureDTO;

/**
 * 实体详情展示对象
 *
 * @author: cpit
 * @date: 2017/5/12
 */
public class MetaEntityShowVO extends MetaEntityListVO {

    private MetaEntityFeatureDTO feature;

    public MetaEntityFeatureDTO getFeature() {
        return feature;
    }

    public void setFeature(MetaEntityFeatureDTO feature) {
        this.feature = feature;
    }
}
