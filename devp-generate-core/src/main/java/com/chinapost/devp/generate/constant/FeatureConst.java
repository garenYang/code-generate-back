package com.chinapost.devp.generate.constant;

import com.chinapost.devp.common.validator.Check;

/**
 * 项目特性常量
 *
 * @author: cpit
 * @date: 2020/11/28
 */
public class FeatureConst {

    @Deprecated
    public static class Boot {

        public static final int BOOT_1 = 1;
        public static final int BOOT_2 = 2;

        @Check
        public static final boolean check(int value) {
            return BOOT_1 == value || BOOT_2 == value;
        }

    }
}
