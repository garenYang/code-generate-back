package com.chinapost.devp.common.util;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author: cpit
 * @date: 2020/5/20
 */
public class UUIDUtil {

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    public static String getUUID16() {
        return getUUID().substring(8, 24);
    }

}
