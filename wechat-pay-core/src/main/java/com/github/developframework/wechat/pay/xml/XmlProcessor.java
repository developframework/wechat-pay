package com.github.developframework.wechat.pay.xml;


import com.github.developframework.wechat.pay.core.WechatPayConfiguration;
import com.github.developframework.wechat.pay.core.RequestXmlBody;
import com.github.developframework.wechat.pay.core.ResponseXmlBody;
import com.github.developframework.wechat.pay.core.WechatPayBody;

/**
 * 抽象XML处理器
 * @param <REQUEST>
 * @param <RESPONSE>
 */
public abstract class XmlProcessor<REQUEST extends RequestXmlBody, RESPONSE extends ResponseXmlBody> extends AbstractXmlComponent {

    protected XmlSerializer<REQUEST> xmlSerializer;

    protected XmlDeserializer<RESPONSE> xmlDeserializer;

    public XmlProcessor(XmlSerializer<REQUEST> xmlSerializer, XmlDeserializer<RESPONSE> xmlDeserializer) {
        this.xmlSerializer = xmlSerializer;
        this.xmlDeserializer = xmlDeserializer;
    }

    public abstract WechatPayBody<RESPONSE> process(WechatPayConfiguration configuration, REQUEST requestXmlBody);
}
