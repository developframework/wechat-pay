package org.develop.wechatpay.http;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * HTTP请求发送器
 * 
 * @author qiuzhenhao
 *
 */
@Slf4j
public class HttpSender implements HttpSendable {

	@Override
	public HttpResponse postHttps(String urlStr, String raw) throws IOException, NoSuchAlgorithmException, KeyManagementException {
		URL url = new URL(urlStr);
		HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
		httpsConn.setRequestProperty("Accept", "application/xml;charset=utf-8");
		httpsConn.setRequestProperty("Content-Type", "application/xml;charset=utf-8");
		httpsConn.setRequestMethod("POST");
		httpsConn.setDoOutput(true);

		log.debug("send http request: {} {}.", httpsConn.getRequestMethod(), urlStr);
		IOUtils.write(raw, httpsConn.getOutputStream(), "utf-8");
		HttpResponse response = new HttpResponse();
		response.setHttpStatus(httpsConn.getResponseCode());
		if (response.getHttpStatus() == 200) {
			List<String> lines = IOUtils.readLines(httpsConn.getInputStream(), "utf-8");
			StringBuffer sb = new StringBuffer();
			lines.forEach(line -> sb.append(line));
			response.setContent(sb.toString());
		} else {
			List<String> lines = IOUtils.readLines(httpsConn.getErrorStream(), "utf-8");
			StringBuffer sb = new StringBuffer();
			lines.forEach(line -> sb.append(line));
			response.setErrorMassage(sb.toString());
		}
		return response;
	}
}
