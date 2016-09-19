package com.github.developframework.wechat.pay.xml;

import com.github.developframework.wechat.pay.utils.Assert;
import com.github.developframework.wechat.pay.utils.SignUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 * 基于注解的Xml序列化器
 * @param <T>
 */
public class BaseAnnotationXmlSerializer<T> extends AbstractXmlComponent implements XmlSerializer<T> {

    @Override
    public String serialize(T body) {
        Class<?> clazz = body.getClass();
        Element rootElement = DocumentHelper.createElement(clazz.getAnnotation(XmlRootElement.class).name());
        Document document = DocumentHelper.createDocument(rootElement);
        checkRequestPropertyValidAndAddElement(rootElement, body);
        printXML(document);
        return rootElement.asXML();
    }

    /**
     * 检查请求参数有效性并加入节点
     *
     * @param rootElement
     * @param body
     */
    private void checkRequestPropertyValidAndAddElement(Element rootElement, final T body) {
        Class<?> clazz = body.getClass();
        Arrays.stream(ArrayUtils.addAll(clazz.getSuperclass().getDeclaredFields(), clazz.getDeclaredFields()))
                .filter(field -> field.isAnnotationPresent(XmlElement.class))
                .forEach(field -> {
                    XmlElement xmlElementAnnotation = field.getAnnotation(XmlElement.class);
                    try {
                        field.setAccessible(true);
                        Object value = field.get(body);
                        addElement(rootElement, xmlElementAnnotation.name(), value, xmlElementAnnotation.required());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    /**
     * 添加节点
     *
     * @param rootElement
     * @param elementName
     * @param obj
     * @param required
     */
    private void addElement(Element rootElement, String elementName, Object obj, boolean required) {
        if (obj == null && !required) {
            return;
        }
        Assert.nonNull(obj, elementName);
        Class<?> clazz = obj.getClass();
        Element element = rootElement.addElement(elementName);
        if(clazz == Integer.class || clazz == Long.class) {
            element.setText(obj.toString());
        } else {
            element.addCDATA(obj.toString());
        }
    }
}
