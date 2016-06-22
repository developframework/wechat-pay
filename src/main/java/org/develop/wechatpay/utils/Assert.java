package org.develop.wechatpay.utils;

/**
 * 断言
 * 
 * @author qiuzhenhao
 *
 */
public final class Assert {

	public static void nonNull(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException();
		}
	}

	public static void nonNull(Object obj, String message) {
		if (obj == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void nonBlank(String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	public static void nonBlank(String str, String message) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}
}
