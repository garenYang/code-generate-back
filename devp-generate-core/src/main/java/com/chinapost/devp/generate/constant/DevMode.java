package com.chinapost.devp.generate.constant;

/**
 * 开发模式常量
 *
 * @author: cpit
 * @date: 2020/2/27
 */
public class DevMode {

    /**
     * 非开发模式：不替换本地代码
     */
    public static final int NO_REPLACE = 0;
    /**
     * 开发模式1：全量替换
     */
    public static final int ALL_REPLACE = 1;
    /**
     * 开发模式2：增量替换
     */
    public static final int INCREMENT_REPLACE = 2;

}
