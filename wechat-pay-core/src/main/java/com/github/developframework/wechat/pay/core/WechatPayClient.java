package com.github.developframework.wechat.pay.core;

import com.github.developframework.scanner.PropertiesBox;
import com.github.developframework.scanner.PropertiesScanner;
import com.github.developframework.wechat.pay.entity.*;
import com.github.developframework.wechat.pay.xml.BaseAnnotationXmlProcessor;
import com.github.developframework.wechat.pay.xml.XmlProcessor;
import lombok.Getter;
import lombok.Setter;

/**
 * 微信支付客户端
 * @author qiuzhenhao
 */
public class WechatPayClient {

    private ApiUrlConfiguration apiUrlConfiguration;

    @Getter
    private WechatPayConfiguration wechatPayConfiguration;

    @Setter
    @Getter
    private WechatPayClientListener wechatPayClientListener;

    public WechatPayClient(WechatPayConfiguration wechatPayConfiguration) {
        this.wechatPayConfiguration = wechatPayConfiguration;
        PropertiesScanner propertiesScanner = new PropertiesScanner();
        PropertiesBox box = propertiesScanner.scan(ApiUrlConfiguration.class);
        this.apiUrlConfiguration = box.get(ApiUrlConfiguration.class);
    }

    /**
     * 统一下单
     * @return
     */
    public WechatPayRequestor unifiedOrderRequestor() {
        XmlProcessor<UnifiedOrderRequestXmlBody, UnifiedOrderResponseXmlBody> xmlProcessor = new BaseAnnotationXmlProcessor<>(apiUrlConfiguration.UNIFIED_ORDER, UnifiedOrderResponseXmlBody.class, wechatPayClientListener);
        return new SimpleWechatPayRequestor<>(xmlProcessor, wechatPayConfiguration);
    }

    /**
     * 查询订单
     * @return
     */
    public WechatPayRequestor orderQueryRequestor() {
        XmlProcessor<OrderQueryRequestXmlBody, OrderQueryResponseXmlBody> xmlProcessor = new BaseAnnotationXmlProcessor<>(apiUrlConfiguration.ORDER_QUERY, OrderQueryResponseXmlBody.class, wechatPayClientListener);
        return new SimpleWechatPayRequestor<>(xmlProcessor, wechatPayConfiguration);
    }

    /**
     * 关闭订单
     * @return
     */
    public WechatPayRequestor closeOrderRequestor() {
        XmlProcessor<CloseOrderRequestXmlBody, CloseOrderResponseXmlBody> xmlProcessor = new BaseAnnotationXmlProcessor<>(apiUrlConfiguration.CLOSE_ORDER, CloseOrderResponseXmlBody.class, wechatPayClientListener);
        return new SimpleWechatPayRequestor<>(xmlProcessor, wechatPayConfiguration);
    }


}
