package com.chinapost.devp.common.pojo.po;

import java.util.Date;

/**
 * 操作日期接口
 *
 * @author: cpit
 * @date: 2020/5/25
 */
public interface OperatedTime {

    /**
     * 获取操作时间
     *
     * @return
     */
    Date getOperatedTime();

    /**
     * 设置操作时间
     *
     * @param operatedTime
     */
    void setOperatedTime(Date operatedTime);

}
