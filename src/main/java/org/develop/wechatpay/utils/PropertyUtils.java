package org.develop.wechatpay.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Properties;

import org.develop.wechatpay.WechatPay;
import org.develop.wechatpay.annotation.Property;

import lombok.Cleanup;

public final class PropertyUtils {

	public static <T> T readProperties(String propertyfilename, Class<T> clazz) {

		Properties pps = new Properties();
		try {
			@Cleanup
			InputStream is = WechatPay.class.getResourceAsStream(propertyfilename);
			if (is == null) {
				throw new FileNotFoundException(propertyfilename + " is not found.");
			}
			pps.load(is);

			T t = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Property propertyAnnotation = field.getAnnotation(Property.class);
				if (Objects.nonNull(propertyAnnotation)) {
					String value = pps.getProperty(propertyAnnotation.key(), propertyAnnotation.defValue());
					if (field.getType() == boolean.class) {
						field.setBoolean(t, new Boolean(value));
					} else if (field.getType() == int.class) {
						field.setInt(t, new Integer(value));
					} else {
						field.set(t, value);
					}
				}
			}
			return t;
		} catch (Exception e) {
			Util.catchException(e);
		}
		return null;

	}
}
