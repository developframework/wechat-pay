package org.develop.wechatpay.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 节点注解
 * 
 * @author qiuzhhenhao
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlElement {

	/**
	 * 属性名称
	 * 
	 * @return
	 */
	public String value();

	/**
	 * 是否必须
	 * 
	 * @return
	 */
	public boolean notNull() default false;
}
