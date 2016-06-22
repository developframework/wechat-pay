package org.develop.wechatpay.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性注解
 * 
 * @author qiuzhhenhao
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Property {

	/**
	 * 键
	 * 
	 * @return
	 */
	public String key();

	/**
	 * 默认值
	 * 
	 * @return
	 */
	public String defValue() default "";
}
