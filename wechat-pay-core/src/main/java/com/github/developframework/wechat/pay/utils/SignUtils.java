package com.github.developframework.wechat.pay.utils;

import com.github.developframework.wechat.pay.annotation.Entity;
import com.github.developframework.wechat.pay.annotation.Sign;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 签名工具类
 */
@Slf4j
public final class SignUtils {

    /**
     * 预检验签名
     * @param xml xml字符串
     * @param APIKey apiKey
     * @param clazz 类型
     * @return 是否通过验证
     */
    @SuppressWarnings("unchecked")
    public static boolean prepareCheckSign(String xml, String APIKey, Class<?> clazz) {
        Field signField = signField(clazz);
        XmlElement xmlElementAnnotation = signField.getAnnotation(XmlElement.class);
        try {
            Document document = DocumentHelper.parseText(xml);
            Element rootElement = document.getRootElement();
            List<SinpleField> sinpleFields = new LinkedList<>();
            String targetSign = null;
            for (Iterator<Element> iterator = rootElement.elementIterator(); iterator.hasNext(); ) {
                Element element = iterator.next();
                if (element.getName().equals(xmlElementAnnotation.name())) {
                    targetSign = element.getTextTrim();
                } else {
                    String text = element.getTextTrim();
                    if(StringUtils.isNotBlank(text)) {
                        sinpleFields.add(new SinpleField(element.getName(), text));
                    }
                }
            }
            if(StringUtils.isBlank(targetSign)) {
                log.warn("sign is blank.");
            }
            final String signStr = makeSignBySinpleFieldList(sinpleFields, APIKey);
            return signStr.equals(targetSign);
        }catch(DocumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 检查签名
     * @param entity 实体对象
     * @param APIKey apiKey
     * @param targetSign 目标签名字符串
     * @return 是否通过验证
     */
    public static boolean checkSign(Object entity, String APIKey, String targetSign) {
        String sign = generateSign(entity, APIKey);
        log.info(sign);
        return sign.equals(targetSign);
    }

    /**
     * 给实体绑定签名
     * @param entity 实体对象
     * @param APIKey apiKey
     */
    public static void bindSign(Object entity, String APIKey) {
        String signStr = generateSign(entity, APIKey);
        Class<?> clazz = entity.getClass();
        try {
            Field signField = signField(clazz);
            signField.setAccessible(true);
            signField.set(entity, signStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成签名
     *
     * @param entity 实体对象
     * @param APIKey apiKey
     * @return
     */
    public static String generateSign(Object entity, String APIKey) {
        Assert.nonNull(entity);
        Assert.nonBlank(APIKey, "APIKey is not null");
        List<SinpleField> sinpleFields = new LinkedList<>();
        Field signField = signField(entity.getClass());
        dealSinpleEntity(entity, sinpleFields, signField);
        return makeSignBySinpleFieldList(sinpleFields, APIKey);
    }

    /**
     * 根据SinpleField列表生成签名
     * @param sinpleFields SinpleField的列表
     * @param APIKey apiKey
     * @return 生成的签名字符串
     */
    private static String makeSignBySinpleFieldList(List<SinpleField> sinpleFields, String APIKey) {
        List<String> list = sinpleFields.stream().sorted(new ASCIIComparator<>(SinpleField::getFieldName)).map(SinpleField::toString).collect(Collectors.toList());
        list.add("key=" + APIKey);
        // 未加密字符串
        String unEncrypt = String.join("&", list);
        return DigestUtils.md5Hex(unEncrypt).toUpperCase();
    }

    /**
     * 处理单个实体
     * @param entity 实体对象
     * @param list SinpleField的列表
     * @param signField 签名字段
     */
    private static void dealSinpleEntity(Object entity, List<SinpleField> list, Field signField) {
        Field[] fields = ArrayUtils.addAll(entity.getClass().getSuperclass().getDeclaredFields(), entity.getClass().getDeclaredFields());
        for (Field field : fields) {
            if(field.equals(signField)) continue;
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(XmlElement.class)) {
                    Object value = field.get(entity);
                    if (value == null) {
                        continue;
                    }
                    list.add(new SinpleField(field.getAnnotation(XmlElement.class).name(), value));
                } else if (field.isAnnotationPresent(Entity.class)) {
                    Object nextEntity = field.get(entity);
                    dealSinpleEntity(nextEntity, list, signField);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询签名字段
     * @param clazz 实体类
     * @return 签名字段
     */
    private static Field signField(Class<?> clazz) {
        String signFieldName = clazz.getAnnotation(Sign.class).value();
        String[] floors = signFieldName.split("\\.");
        Field field = null;
        Class<?> tempClass = clazz;
        for (int i = 0; i < floors.length; i++) {
            try {
                field = tempClass.getDeclaredField(floors[i]);
                tempClass = field.getType();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return field;
    }

}
