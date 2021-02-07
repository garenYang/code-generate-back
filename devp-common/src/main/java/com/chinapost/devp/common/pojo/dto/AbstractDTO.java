package com.chinapost.devp.common.pojo.dto;


import com.chinapost.devp.common.util.JsonUtil;

import java.io.Serializable;

/**
 * 数据传输对象超类
 *
 * @author: cpit
 * @date: 2020/12/10
 */
public abstract class AbstractDTO implements Serializable {

    private static final long serialVersionUID = 1915714417292764241L;

    @Override
    public String toString() {
        return JsonUtil.toJSONString(this);
    }

}
