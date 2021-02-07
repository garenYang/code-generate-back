package com.chinapost.devp.generate.exception;

/**
 * 跳过当前文件异常
 *
 * @author: cpit
 * @date: 2020/10/1
 */
public class SkipCurrentException extends RuntimeException {

    public SkipCurrentException() {
        super("跳过当前文件");
    }

}
