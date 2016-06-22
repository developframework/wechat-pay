package org.develop.wechatpay.utils;

import org.develop.wechatpay.exception.WechatPayException;

/**
 * 工具类
 * 
 * @author qiuzhenhao
 *
 */
public final class Util {

	/**
	 * 捕获异常转为微信支付异常
	 * 
	 * @param e
	 */
	public static void catchException(Throwable e) {
		throw new WechatPayException(e);
	}
}
