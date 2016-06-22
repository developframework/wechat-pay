package org.develop.wechatpay.converter;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Objects;

import org.develop.wechatpay.annotation.Condition;
import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.annotation.XmlElementArray;
import org.develop.wechatpay.utils.Assert;
import org.develop.wechatpay.utils.Util;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import lombok.extern.slf4j.Slf4j;

/**
 * 基于注解的xml转换器
 * 
 * @author qiuzhenhao
 *
 * @param <T>
 */
@Slf4j
public class BaseAnnotationXmlConverter<T> implements XmlConverter<T> {

	@Override
	public String toXML(T t) {
		Element root = DocumentHelper.createElement("xml");
		Document document = DocumentHelper.createDocument(root);
		checkRequestPropertyValidAndAddElement(root, t);
		printXML(document);
		return root.asXML();
	}

	@Override
	public T toEntity(String xml, Class<T> clazz) {
		try {
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			T t = dealSinpleEntity(root, clazz);
			printXML(document);
			return t;
		} catch (DocumentException | IllegalArgumentException | IllegalAccessException | InstantiationException e) {
			Util.catchException(e);
		}
		return null;
	}

	/**
	 * 检查请求参数有效性并加入节点
	 * 
	 * @param request
	 */
	protected void checkRequestPropertyValidAndAddElement(Element root, T t) {

		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			XmlElement xmlElement = field.getAnnotation(XmlElement.class);
			if (xmlElement == null) {
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

	/**
	 * 处理单个实体
	 * 
	 * @param root
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private <E> E dealSinpleEntity(Element root, Class<E> clazz) throws InstantiationException, IllegalAccessException {
		E entity = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);

			// 获取所有注解
			Condition condition = field.getAnnotation(Condition.class);
			XmlElement xmlElement = field.getAnnotation(XmlElement.class);
			XmlElementArray xmlElementArray = field.getAnnotation(XmlElementArray.class);

			// 处理@Condition
			if (Objects.nonNull(condition)) {
				Element element = root.element(condition.element());
				if (Objects.nonNull(element)) {
					String text = root.element(condition.element()).getTextTrim();
					if (condition.value().equals(text)) {
						dealSinpleEntity(root, field.getType());
					}
				}
			}

			// 处理@XmlElement
			if (Objects.nonNull(xmlElement)) {
				Element element = root.element(xmlElement.value());
				if (Objects.nonNull(element)) {
					if (field.getType() == Integer.class) {
						field.set(entity, new Integer(element.getTextTrim()));
					} else {
						field.set(entity, element.getTextTrim());
					}
				}
			}

			// 处理@XmlElementArray
			if (Objects.nonNull(xmlElementArray)) {
				Element indexElement = root.element(xmlElementArray.indexElement());
				if (Objects.nonNull(indexElement)) {
					int size = new Integer(indexElement.getTextTrim());
					// 反射获取数组元素类型
					Class<?> componentType = field.getType().getComponentType();
					// 反射生成数组对象
					Object array = Array.newInstance(componentType, size);
					for (int i = 0; i < size; i++) {
						Element element = root.element(xmlElementArray.value().replace("$n", String.valueOf(i)));
						if (Objects.nonNull(element)) {
							String text = element.getTextTrim();
							if (componentType == Integer.class) {
								Array.setInt(array, i, new Integer(text));
							} else {
								Array.set(array, i, text);
							}
						}
					}
					field.set(entity, array);
				}
			}
		}
		return entity;
	}

	/**
	 * 打印XML
	 * 
	 * @param document
	 */
	private void printXML(Document document) {
		if (log.isDebugEnabled()) {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setExpandEmptyElements(true);
			format.setSuppressDeclaration(true);
			StringWriter stringWriter = new StringWriter();
			XMLWriter writer = new XMLWriter(stringWriter, format);
			try {
				writer.write(document);
				log.debug(stringWriter.toString());
			} catch (IOException e) {
				Util.catchException(e);
			}
		}
	}

}
