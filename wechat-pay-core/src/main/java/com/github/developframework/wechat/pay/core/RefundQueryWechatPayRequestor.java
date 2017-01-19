package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.entity.RefundQueryRequestXmlBody;
import com.github.developframework.wechat.pay.entity.RefundQueryResponseXmlBody;
import com.github.developframework.wechat.pay.xml.XmlProcessor;

public class RefundQueryWechatPayRequestor extends SimpleWechatPayRequestor<RefundQueryRequestXmlBody, RefundQueryResponseXmlBody> {

    public RefundQueryWechatPayRequestor(XmlProcessor<RefundQueryRequestXmlBody, RefundQueryResponseXmlBody> xmlProcessor, WechatPayConfiguration configuration) {
        super(xmlProcessor, configuration);
    }
}
