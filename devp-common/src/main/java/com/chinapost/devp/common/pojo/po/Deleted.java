package com.chinapost.devp.common.pojo.po;

/**
 * 是否逻辑删除接口
 *
 * @author: cpit
 * @date: 2020/5/25
 */
public interface Deleted {

    /**
     * 获取逻辑删除标识
     *
     * @return
     */
    Boolean getDeleted();

    /**
     * 设置逻辑删除标识
     *
     * @param deleted
     */
    void setDeleted(Boolean deleted);

}
