package org.develop.wechatpay.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckSignFailedException extends RuntimeException {

	private static final long serialVersionUID = -2221285023230274253L;

	public CheckSignFailedException() {
		log.warn("check sign failed.");
	}
}
