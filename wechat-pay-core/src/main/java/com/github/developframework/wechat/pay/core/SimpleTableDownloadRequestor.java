package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.http.HttpResponse;
import com.github.developframework.wechat.pay.xml.XmlProcessor;
import lombok.Getter;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 *
 */
public class SimpleTableDownloadRequestor<REQUEST extends RequestXmlBody, RESPONSE extends ResponseXmlBody> implements TableDownloadRequestor<REQUEST> {

    private XmlProcessor<REQUEST, RESPONSE> xmlProcessor;

    @Getter
    private WechatPayConfiguration wechatPayConfiguration;

    public SimpleTableDownloadRequestor(XmlProcessor<REQUEST, RESPONSE> xmlProcessor, WechatPayConfiguration wechatPayConfiguration) {
        this.xmlProcessor = xmlProcessor;
        this.wechatPayConfiguration = wechatPayConfiguration;
    }

    @Override
    public TableResponseXmlBody request(REQUEST body, Class<? extends TableResponseXmlBody> clazz) {
        try {
            TableResponseXmlBody tableResponseXmlBody = clazz.newInstance();
            final HttpResponse httpResponse = xmlProcessor.onlyHttpProcess(body);
            if (httpResponse.isOK()) {
                String content = httpResponse.getContent();
                tableResponseXmlBody.setSourceContent(content);
                try {
                    Document document = DocumentHelper.parseText(content);
                    Element root = document.getRootElement();
                    tableResponseXmlBody.setReturnCode(root.element("return_code").getTextTrim());
                    tableResponseXmlBody.setReturnMsg(root.element("return_msg").getTextTrim());
                } catch (DocumentException e) {
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
