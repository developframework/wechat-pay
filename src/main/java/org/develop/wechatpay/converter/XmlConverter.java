package org.develop.wechatpay.converter;

public interface XmlConverter<T> {

	public String toXML(T t);

	public T toEntity(String xml, Class<T> clazz);

}
