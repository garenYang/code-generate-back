package com.chinapost.devp.common.optimistic;

/**
 * 乐观锁异常
 *
 * @author: cpit
 * @date 2017/2/21
 */
public class OptimisticException extends RuntimeException {

    public OptimisticException() {

    }

    public OptimisticException(String message) {
        super(message);
    }
}
