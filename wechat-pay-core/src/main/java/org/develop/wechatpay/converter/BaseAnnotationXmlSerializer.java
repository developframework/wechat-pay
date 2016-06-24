package org.develop.wechatpay.converter;

import java.lang.reflect.Field;
import java.util.Iterator;

import org.develop.wechatpay.annotation.SignElement;
import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.utils.Assert;
import org.develop.wechatpay.utils.Util;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 基于注解的XML序列化器
 * 
 * @author qiuzhenhao
 *
 * @param <T>
 */
public class BaseAnnotationXmlSerializer<T> extends AbstractXmlComponent implements XmlSerializer<T> {

	@Override
	public String serialize(T t, String apiKey) {
		Element root = DocumentHelper.createElement("xml");
		Document document = DocumentHelper.createDocument(root);
		checkRequestPropertyValidAndAddElement(root, t, apiKey);
		printXML(document);
		return root.asXML();
	}

	/**
	 * 检查请求参数有效性并加入节点
	 * 
	 * @param root
	 * @param t
	 * @param APIKey
	 */
	protected void checkRequestPropertyValidAndAddElement(Element root, T t, String APIKey) {

		Field sign = null;
		for (Iterator<Field> iterator = super.iteratorHasXmlAnnotation(t.getClass()); iterator.hasNext();) {
			Field field = iterator.next();
			XmlElement xmlElement = field.getAnnotation(XmlElement.class);
			SignElement signElement = field.getAnnotation(SignElement.class);
			if (xmlElement == null) {
				continue;
			}
			if (signElement != null) {
				sign = field;
				continue;
			}
			try {
				field.setAccessible(true);
				Object value = field.get(t);
				if (xmlElement.notNull() && value == null) {
					String fieldName = field.getName();
					throw new IllegalArgumentException(fieldName + " must not null!");
				}
				addElement(root, xmlElement.value(), value, !xmlElement.notNull());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		// 加签名
		if (sign != null) {
			XmlElement xmlElement = sign.getAnnotation(XmlElement.class);
			String signStr = Util.generateSign(t, APIKey);
			addElement(root, xmlElement.value(), signStr, !xmlElement.notNull());
		}
	}

	/**
	 * 添加节点
	 * 
	 * @param root
	 * @param elementName
	 * @param obj
	 * @param allowNull
	 */
	private void addElement(Element root, String elementName, Object obj, boolean allowNull) {
		if (obj == null && allowNull) {
			return;
		}
		Assert.nonNull(obj, elementName);
		root.addElement(elementName).setText(obj.toString());
	}
}
