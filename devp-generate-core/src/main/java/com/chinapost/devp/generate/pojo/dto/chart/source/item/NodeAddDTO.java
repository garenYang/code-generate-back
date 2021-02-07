package com.chinapost.devp.generate.pojo.dto.chart.source.item;

import lombok.Data;

/**
 * @author yanglong
 * date 2021-02-01
 */
@Data
public class NodeAddDTO {
    private DetailColumnAddDTO id;

    private DetailColumnAddDTO parentId;

    private DetailColumnAddDTO parentIds;

    private DetailColumnAddDTO label;

    private DetailColumnAddDTO sort;

    private DetailColumnAddDTO leaf;

}
