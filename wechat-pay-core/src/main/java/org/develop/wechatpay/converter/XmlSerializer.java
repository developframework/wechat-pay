package org.develop.wechatpay.converter;

public interface XmlSerializer<T> {

	public String serialize(T t, String apiKey);
}
