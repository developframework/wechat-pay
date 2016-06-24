package org.develop.wechatpay.http;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * 可发送HTTP请求的接口
 * 
 * @author qiuzhenhao
 *
 */
public interface HttpSendable {

	public HttpResponse postHttps(String url, String raw) throws IOException, NoSuchAlgorithmException, KeyManagementException;
}
