package com.github.developframework.wechat.pay.xml;

/**
 * Xml序列化器
 */
public interface XmlSerializer<T> {

    String serialize(T t);
}
