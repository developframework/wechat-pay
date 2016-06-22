package org.develop.wechatpay.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WechatPayException extends RuntimeException {

	private static final long serialVersionUID = -8437102593106600140L;

	public WechatPayException(Throwable e) {
		log.error(e.getMessage(), e);
	}
}
