package com.chinapost.devp.common.pojo.po;

import java.time.LocalDateTime;

/**
 * 操作时间接口-jsr310时间API
 *
 * @author wn
 * @date 2021/01/22
 */
public interface Jsr310OperatedTime {

    LocalDateTime getOperatedTime();

    void setOperatedTime(LocalDateTime operatedTime);
}

