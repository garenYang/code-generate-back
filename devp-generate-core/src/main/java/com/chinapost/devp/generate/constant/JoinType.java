package com.chinapost.devp.generate.constant;

import com.chinapost.devp.common.validator.Check;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举【关联类型】
 *
 * @author: cpit
 * @date: 2020/04/04
 */
public enum JoinType {

    /**
     * inner_join
     */
    INNER_JOIN(1, "inner_join"),
    /**
     * left_join
     */
    LEFT_JOIN(2, "left_join"),
    /**
     * right_join
     */
    RIGHT_JOIN(3, "right_join");


    /**
     * 枚举值罗列，给swagger接口文档展示用
     */
    public static final String VALUES_STR = "1,2,3";
    private static final Map<Integer, JoinType> LOOKUP = new HashMap<>();

    static {
        for (JoinType e : JoinType.values()) {
            LOOKUP.put(e.value, e);
        }
    }

    private final Integer value;
    private final String desc;


    JoinType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static JoinType find(Integer value) {
        return LOOKUP.get(value);
    }

    public static JoinType findByDesc(String desc) {
        for (JoinType e : JoinType.values()) {
            if (e.getDesc().equals(desc)) {
                return e;
            }
        }
        return null;
    }


    /**
     * desc映射value
     *
     * @param desc
     * @return
     */
    public static Integer descToValue(String desc) {
        JoinType theEnum = findByDesc(desc);
        if (theEnum != null) {
            return theEnum.getValue();
        }
        return null;
    }

    /**
     * value映射desc
     *
     * @param value
     * @return
     */
    public static String valueToDesc(Integer value) {
        JoinType theEnum = find(value);
        if (theEnum != null) {
            return theEnum.getDesc();
        }
        return null;
    }

    /**
     * 校验有效性
     */
    @Check
    public static final boolean validate(Integer value) {
        JoinType theEnum = find(value);
        return theEnum != null;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }


}

