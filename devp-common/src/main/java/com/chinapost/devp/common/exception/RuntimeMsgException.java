package com.chinapost.devp.common.exception;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class RuntimeMsgException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RuntimeMsgException(String message) {
		super(message);
	}

	public RuntimeMsgException(Throwable cause) {
		super(cause);
	}

	public RuntimeMsgException(String message, Throwable cause) {
		super(message, cause);
	}

	public RuntimeMsgException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
