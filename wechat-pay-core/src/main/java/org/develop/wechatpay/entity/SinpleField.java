package org.develop.wechatpay.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SinpleField {

	private String fieldName;

	private Object value;

	@Override
	public String toString() {
		return String.format("%s=%s", fieldName, value.toString());
	}
}
