package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.entity.CloseOrderRequestXmlBody;
import com.github.developframework.wechat.pay.entity.CloseOrderResponseXmlBody;
import com.github.developframework.wechat.pay.xml.XmlProcessor;

public class CloseOrderWechatPayRequestor extends SimpleWechatPayRequestor<CloseOrderRequestXmlBody, CloseOrderResponseXmlBody> {

    public CloseOrderWechatPayRequestor(XmlProcessor<CloseOrderRequestXmlBody, CloseOrderResponseXmlBody> xmlProcessor, WechatPayConfiguration configuration) {
        super(xmlProcessor, configuration);
    }
}
