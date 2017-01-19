package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.entity.RefundRequestXmlBody;
import com.github.developframework.wechat.pay.entity.RefundResponseXmlBody;
import com.github.developframework.wechat.pay.xml.XmlProcessor;

public class RefundOrderWechatPayRequestor extends SimpleWechatPayRequestor<RefundRequestXmlBody, RefundResponseXmlBody> {

    public RefundOrderWechatPayRequestor(XmlProcessor<RefundRequestXmlBody, RefundResponseXmlBody> xmlProcessor, WechatPayConfiguration configuration) {
        super(xmlProcessor, configuration);
    }
}
