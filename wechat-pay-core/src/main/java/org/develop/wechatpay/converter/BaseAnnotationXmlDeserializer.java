package org.develop.wechatpay.converter;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Objects;

import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.annotation.XmlElementArray;
import org.develop.wechatpay.entity.ReturnSuccessResponse;
import org.develop.wechatpay.entity.WechatEntity;
import org.develop.wechatpay.utils.Util;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 基于注解的XML反序列化器
 * 
 * @author qiuzhenhao
 *
 * @param <INFO>
 */
public class BaseAnnotationXmlDeserializer<INFO> extends AbstractXmlComponent implements XmlDeserializer<INFO> {

	@SuppressWarnings("unchecked")
	@Override
	public WechatEntity<INFO> deserialize(String xml, Class<INFO> clazz) {
		try {
			Document document = DocumentHelper.parseText(xml);
			super.printXML(document);
			Element root = document.getRootElement();
			WechatEntity<INFO> entity = makeWechatEntity(root);
			if (entity.isReturnSuccess()) {
				ReturnSuccessResponse<INFO> returnSuccessResponse = dealSinpleEntity(root, ReturnSuccessResponse.class);
				entity.setReturnSuccessResponse(returnSuccessResponse);
				if (returnSuccessResponse.isResultSuccess()) {
					INFO resultSuccessResponseInfo = dealSinpleEntity(root, clazz);
					returnSuccessResponse.setResultSuccessResponseInfo(resultSuccessResponseInfo);
				}
			}
			return entity;
		} catch (DocumentException | IllegalArgumentException | IllegalAccessException | InstantiationException e) {
			Util.catchException(e);
		}
		return null;
	}

	/**
	 * 生成响应实体
	 * 
	 * @param root
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private WechatEntity<INFO> makeWechatEntity(Element root) throws IllegalArgumentException, IllegalAccessException {
		WechatEntity<INFO> entity = new WechatEntity<>();
		for (Iterator<Field> iterator = super.iteratorHasXmlAnnotation(WechatEntity.class); iterator.hasNext();) {
			Field field = iterator.next();
			field.setAccessible(true);
			XmlElement xmlElement = field.getAnnotation(XmlElement.class);
			String text = super.elementText(root, xmlElement);
			field.set(entity, text);
		}
		return entity;
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
		for (Iterator<Field> iterator = super.iteratorHasXmlAnnotation(clazz); iterator.hasNext();) {
			Field field = iterator.next();
			field.setAccessible(true);

			// 获取所有注解
			XmlElement xmlElement = field.getAnnotation(XmlElement.class);
			XmlElementArray xmlElementArray = field.getAnnotation(XmlElementArray.class);

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

}
