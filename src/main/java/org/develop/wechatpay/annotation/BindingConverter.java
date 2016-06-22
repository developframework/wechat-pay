package org.develop.wechatpay.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.develop.wechatpay.converter.XmlConverter;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindingConverter {

	@SuppressWarnings("rawtypes")
	public Class<? extends XmlConverter> value();
}
