package com.chinapost.devp.common.xss;

import java.lang.annotation.*;

/**
 * 无视XSS脚本
 *
 * @author: cpit
 * @date: 2020/11/19
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface IgnoreXSS {
}
