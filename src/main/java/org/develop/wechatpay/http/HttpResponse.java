package org.develop.wechatpay.http;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HttpResponse {

	private int httpStatus;

	private String errorMassage;

	private String content;

	public boolean isOK() {
		return httpStatus == 200;
	}
}
