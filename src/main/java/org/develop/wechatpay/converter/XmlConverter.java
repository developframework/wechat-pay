package org.develop.wechatpay.converter;

/**
 * XML转换器接口
 * 
 * @author qiuzhenhao
 *
 * @param <T>
 */
public interface XmlConverter<T> {

	/**
	 * 转写成XML格式
	 * 
	 * @param t
	 * @return
	 */
	public String toXML(T t);

	/**
	 * 转写成实体
	 * 
	 * @param xml
	 * @param clazz
	 * @return
	 */
	public T toEntity(String xml, Class<T> clazz);

}
