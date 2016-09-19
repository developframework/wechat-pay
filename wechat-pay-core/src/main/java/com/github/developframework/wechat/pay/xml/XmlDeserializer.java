package com.github.developframework.wechat.pay.xml;

import com.github.developframework.wechat.pay.core.WechatPayBody;

/**
 * Xml反序列化器
 * @param <T>
 */
public interface XmlDeserializer<T> {

    WechatPayBody<T> deserialize(String xml, Class<T> clazz);
}
