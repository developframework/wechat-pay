package org.develop.wechatpay.converter;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import org.develop.wechatpay.annotation.Condition;
import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.annotation.XmlElementArray;
import org.develop.wechatpay.utils.Util;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractXmlComponent {

	/**
	 * 打印XML
	 * 
	 * @param document
	 */
	protected void printXML(Document document) {
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

	/**
	 * 获取节点文本
	 * 
	 * @param root
	 * @param xmlElement
	 * @return
	 */
	protected String elementText(Element root, XmlElement xmlElement) {
		Element element = root.element(xmlElement.value());
		return Objects.nonNull(element) ? element.getTextTrim() : null;
	}

	/**
	 * 获取有注解的属性字段
	 * 
	 * @param clazz
	 * @return
	 */
	protected Iterator<Field> iteratorHasXmlAnnotation(Class<?> clazz) {
		return Arrays.asList(clazz.getDeclaredFields()).stream().filter(field -> Objects.nonNull(field.getAnnotation(Condition.class)) | Objects.nonNull(field.getAnnotation(XmlElement.class)) | Objects.nonNull(field.getAnnotation(XmlElementArray.class))).iterator();
	}
}
