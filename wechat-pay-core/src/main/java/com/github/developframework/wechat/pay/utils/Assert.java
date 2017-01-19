package com.github.developframework.wechat.pay.utils;

/**
 * 断言
 * 
 * @author qiuzhenhao
 *
 */
public final class Assert {

	/**
	 * 断言对象不为null
	 * 
	 * @param obj
	 */
	public static void nonNull(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 断言对象不为null
	 * 
	 * @param obj
	 * @param message
	 */
	public static void nonNull(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * 断言字符串
	 * 
	 * @param str
	 */
	public static void nonBlank(String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 断言字符串
	 * 
	 * @param str
	 * @param message
	 */
	public static void nonBlank(String str, String message) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}
}
