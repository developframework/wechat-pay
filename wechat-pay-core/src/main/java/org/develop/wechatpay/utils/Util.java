package org.develop.wechatpay.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.develop.wechatpay.annotation.SignElement;
import org.develop.wechatpay.annotation.XmlElement;
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

	/**
	 * 生成签名
	 * 
	 * @param entity
	 * @param APIKey
	 * @return
	 */
	public static String generateSign(Object entity, String APIKey) {
		Assert.nonNull(entity);
		Assert.nonBlank(APIKey, "APIKey is not null");
		List<String> list = new ArrayList<>();
		for (Iterator<Field> iterator = dealSinpleEntity(entity.getClass()); iterator.hasNext();) {
			Field field = iterator.next();
			field.setAccessible(true);
			try {
				Object value = field.get(entity);
				if (value == null)
					continue;
				String one = String.format("%s=%s", field.getAnnotation(XmlElement.class).value(), value.toString());
				list.add(one);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				Util.catchException(e);
			}
		}
		list.add("key=" + APIKey);
		// 未加密字符串
		String unEncrypt = String.join("&", list);
		System.out.println(unEncrypt);
		return DigestUtils.md5Hex(unEncrypt).toUpperCase();
	}

	/**
	 * 处理单个实体类的字段筛选排序
	 * 
	 * @param clazz
	 * @return
	 */
	private static Iterator<Field> dealSinpleEntity(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();

		// 字典排序器
		final ASCIIComparator<Field> asciiComparator = new ASCIIComparator<>(field -> field.getAnnotation(XmlElement.class).value());

		// 过滤并按字典排序
		return Arrays.asList(fields).stream().filter(field -> Objects.nonNull(field.getAnnotation(XmlElement.class)) && Objects.isNull(field.getAnnotation(SignElement.class))).sorted(asciiComparator).iterator();
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param count
	 * @return
	 */
	public static String randomNonceStr(int count) {
		return RandomStringUtils.randomAlphanumeric(count);
	}
}
