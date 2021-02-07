package com.chinapost.devp.common.pojo.po;

import java.time.LocalDateTime;

/**
 * 创建时间接口-jsr310时间API
 *
 * @author wn
 * @date 2021/01/22
 */
public interface Jsr310CreatedTime {

    LocalDateTime getCreatedTime();

    void setCreatedTime(LocalDateTime createdTime);

}

