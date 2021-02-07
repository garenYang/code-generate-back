package com.chinapost.devp.common.optimistic;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用乐观锁
 *
 * @author: cpit
 * @date: 2020/2/21
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({OptimisticLockConfiguration.class})
public @interface EnableOptimisticLock {


}
