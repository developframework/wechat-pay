package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.http.HttpResponse;
import com.github.developframework.wechat.pay.xml.XmlProcessor;

/**
 *
 */
public class SimpleFileDownloadRequestor<REQUEST extends RequestXmlBody, RESPONSE extends ResponseXmlBody> implements FileDownloadRequestor<REQUEST>{

    private XmlProcessor<REQUEST, RESPONSE> xmlProcessor;

    private WechatPayConfiguration wechatPayConfiguration;

    public SimpleFileDownloadRequestor(XmlProcessor<REQUEST, RESPONSE> xmlProcessor, WechatPayConfiguration wechatPayConfiguration) {
        this.xmlProcessor = xmlProcessor;
        this.wechatPayConfiguration = wechatPayConfiguration;
    }

    @Override
    public String request(REQUEST body) {
        try {
            final HttpResponse httpResponse = xmlProcessor.onlyHttpProcess(body);
            if(httpResponse.isOK()) {
                return httpResponse.getContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
