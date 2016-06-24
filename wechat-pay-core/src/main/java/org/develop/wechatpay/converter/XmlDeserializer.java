package org.develop.wechatpay.converter;

import org.develop.wechatpay.entity.WechatEntity;

public interface XmlDeserializer<INFO> {

	/**
	 * 将xml文本转化为WechatEntity
	 * 
	 * @param xml
	 * @param clazz
	 * @return
	 */
	public WechatEntity<INFO> deserialize(String xml, Class<INFO> clazz);
}
