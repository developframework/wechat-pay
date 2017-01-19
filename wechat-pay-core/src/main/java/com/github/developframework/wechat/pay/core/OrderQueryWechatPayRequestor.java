package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.entity.OrderQueryRequestXmlBody;
import com.github.developframework.wechat.pay.entity.OrderQueryResponseXmlBody;
import com.github.developframework.wechat.pay.xml.XmlProcessor;

public class OrderQueryWechatPayRequestor extends SimpleWechatPayRequestor<OrderQueryRequestXmlBody, OrderQueryResponseXmlBody> {

    public OrderQueryWechatPayRequestor(XmlProcessor<OrderQueryRequestXmlBody, OrderQueryResponseXmlBody> xmlProcessor, WechatPayConfiguration configuration) {
        super(xmlProcessor, configuration);
    }
}
