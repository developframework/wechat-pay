package org.develop.wechatpay.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.develop.wechatpay.converter.XmlConverter;

/**
 * 绑定转换器注解
 * 
 * @author qiuzhenhao
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindingConverter {

	/**
	 * 设定绑定转换器类
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Class<? extends XmlConverter> value();
}
