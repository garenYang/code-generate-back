package com.chinapost.devp.generate.util;

import com.chinapost.devp.common.util.SafeUtil;
import com.chinapost.devp.generate.constant.PatternConst;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * 版本号工具类
 *
 * @author: cpit
 * @date: 2020/01/18
 */
public class VersionUtil {

    /**
     * 解析版本号字符串
     *
     * @param version
     * @return
     */
    public static int[] parseVersion(String version) {
        return Arrays.stream(version.split("\\."))
                .filter(s -> Pattern.matches(PatternConst.NUM, s))
                .mapToInt(SafeUtil::getInteger)
                .toArray();
    }

    /**
     * 比较两个版本号
     *
     * @param a
     * @param b
     * @return
     */
    public static int compareVersion(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            int ai = a[i];
            int bi = b[i];
            if (ai > bi) {
                return 1;
            } else if (ai < bi) {
                return -1;
            }
        }
        return 0;
    }


}
