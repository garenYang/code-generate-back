package com.chinapost.devp.generate.constant;

import com.chinapost.devp.common.validator.Check;

/**
 * 标签类型常量
 *
 * @author: cpit
 * @date: 2020-09-13
 */
public class LabelType {


    public static final String PROJECT = "project";
    public static final String ENTITY = "entity";
    public static final String FIELD = "field";

    @Check
    public static final boolean check(String value) {
        return PROJECT.equals(value) || ENTITY.equals(value)
                || FIELD.equals(value);
    }

}
