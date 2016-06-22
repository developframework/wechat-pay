package org.develop.wechatpay.http;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public interface HttpSendable {

	public HttpResponse get(String url) throws IOException;

	public HttpResponse postHttps(String url, String raw) throws IOException, NoSuchAlgorithmException, KeyManagementException;
}
