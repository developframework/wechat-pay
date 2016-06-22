package org.develop.wechatpay.utils;

import org.develop.wechatpay.exception.WechatPayException;

public final class Util {

	public static void catchException(Throwable e) {
		throw new WechatPayException(e);
	}
}
