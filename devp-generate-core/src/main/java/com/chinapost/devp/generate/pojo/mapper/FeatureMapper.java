package com.chinapost.devp.generate.pojo.mapper;

import com.chinapost.devp.common.util.JsonUtil;
import com.chinapost.devp.generate.pojo.dto.MetaEntityFeatureDTO;
import com.chinapost.devp.generate.pojo.dto.MetaMtmFeatureDTO;
import com.chinapost.devp.generate.pojo.dto.MetaProjectFeatureDTO;
import com.chinapost.devp.generate.pojo.dto.chart.source.ChartSourceFeatureDTO;

/**
 * 特性DTO转json
 *
 * @author: cpit
 * @date: 2020/11/28
 */
public class FeatureMapper {

    public static String asString(MetaProjectFeatureDTO dto) {
        return dto != null ? JsonUtil.toJSONString(dto) : null;
    }

    public static String asString(MetaEntityFeatureDTO dto) {
        return dto != null ? JsonUtil.toJSONString(dto) : null;
    }

    public static String asString(MetaMtmFeatureDTO dto) {
        return dto != null ? JsonUtil.toJSONString(dto) : null;
    }

    public static String asString(ChartSourceFeatureDTO dto) {
        return dto != null ? JsonUtil.toJSONString(dto) : null;
    }

    public static MetaProjectFeatureDTO asProjectFeatureDTO(String str) {
        return JsonUtil.parseObject(str, MetaProjectFeatureDTO.class);
    }

    public static MetaEntityFeatureDTO asEntityFeatureDTO(String str) {
        return JsonUtil.parseObject(str, MetaEntityFeatureDTO.class);
    }

    public static MetaMtmFeatureDTO asMtmFeatureDTO(String str) {
        return JsonUtil.parseObject(str, MetaMtmFeatureDTO.class);
    }

    public static ChartSourceFeatureDTO asChartSourceFeatureDTO(String str) {
        return JsonUtil.parseObject(str, ChartSourceFeatureDTO.class);
    }
}
