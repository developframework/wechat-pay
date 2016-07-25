package org.develop.wechatpay.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.develop.wechatpay.annotation.Entity;
import org.develop.wechatpay.annotation.SignElement;
import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.entity.SinpleField;
import org.develop.wechatpay.exception.WechatPayException;

import lombok.extern.slf4j.Slf4j;

/**
 * 工具类
 * 
 * @author qiuzhenhao
 *
 */
@Slf4j
public final class Util {

	/**
	 * 捕获异常转为微信支付异常
	 * 
	 * @param e
	 */
	public static void catchException(Throwable e) {
		e.printStackTrace();
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
		for (Iterator<SinpleField> iterator = getSinpleFieldIterator(entity); iterator.hasNext();) {
			SinpleField sinpleField = iterator.next();
			list.add(sinpleField.toString());
		}
		list.add("key=" + APIKey);
		// 未加密字符串
		String unEncrypt = String.join("&", list);
		return DigestUtils.md5Hex(unEncrypt).toUpperCase();
	}

	public static boolean checkSign(Object entity, String APIKey, String targetSign) {
		String sign = generateSign(entity, APIKey);
		log.info(sign);
		return sign.equals(targetSign);
	}

	/**
	 * 处理单个实体类的字段筛选排序
	 * 
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	private static Iterator<SinpleField> getSinpleFieldIterator(Object entity) {
		List<SinpleField> list = new LinkedList<>();
		dealSinpleEntity(list, entity);
		// 字典排序器
		final ASCIIComparator<SinpleField> asciiComparator = new ASCIIComparator<>(sinpleField -> sinpleField.getFieldName());

		// 按字典排序
		return list.stream().sorted(asciiComparator).iterator();
	}

	private static void dealSinpleEntity(List<SinpleField> list, Object entity) {
		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				XmlElement xmlElementAnnotation = field.getAnnotation(XmlElement.class);
				SignElement signElementAnnotation = field.getAnnotation(SignElement.class);
				if (Objects.nonNull(xmlElementAnnotation) && Objects.isNull(signElementAnnotation)) {
					field.setAccessible(true);
					Object value = field.get(entity);
					if (value == null)
						continue;
					list.add(new SinpleField(xmlElementAnnotation.value(), value));
				} else if (Objects.nonNull(field.getAnnotation(Entity.class))) {
					field.setAccessible(true);
					Object nextEntity = field.get(entity);
					dealSinpleEntity(list, nextEntity);
				}
			} catch (Exception e) {
				Util.catchException(e);
			}
		}
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
