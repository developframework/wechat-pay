package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.entity.UnifiedOrderRequestXmlBody;
import com.github.developframework.wechat.pay.entity.UnifiedOrderResponseXmlBody;
import com.github.developframework.wechat.pay.xml.XmlProcessor;

public class UnifiedOrderWechatPayRequestor extends SimpleWechatPayRequestor<UnifiedOrderRequestXmlBody, UnifiedOrderResponseXmlBody> {

    public UnifiedOrderWechatPayRequestor(XmlProcessor xmlProcessor, WechatPayConfiguration configuration) {
        super(xmlProcessor, configuration);
    }
}
