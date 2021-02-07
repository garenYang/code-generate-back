package com.chinapost.devp.generate.pojo.vo;

import com.chinapost.devp.generate.pojo.dto.MetaProjectFeatureDTO;
import lombok.Data;

/**
 * 项目详情展示对象
 *
 * @author: cpit
 * @date: 2020/5/24
 */
@Data
public class MetaProjectShowVO extends MetaProjectListVO {

    private MetaProjectFeatureDTO feature;

}
