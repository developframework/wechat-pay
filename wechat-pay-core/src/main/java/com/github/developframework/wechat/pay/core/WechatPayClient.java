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
     * @return UnifiedOrderWechatPayRequestor
     */
    public UnifiedOrderWechatPayRequestor unifiedOrderRequestor() {
        XmlProcessor<UnifiedOrderRequestXmlBody, UnifiedOrderResponseXmlBody> xmlProcessor = new BaseAnnotationXmlProcessor<>(apiUrlConfiguration.UNIFIED_ORDER, UnifiedOrderResponseXmlBody.class, wechatPayClientListener);
        return new UnifiedOrderWechatPayRequestor(xmlProcessor, wechatPayConfiguration);
    }

    /**
     * 查询订单
     * @return OrderQueryWechatPayRequestor
     */
    public OrderQueryWechatPayRequestor orderQueryRequestor() {
        XmlProcessor<OrderQueryRequestXmlBody, OrderQueryResponseXmlBody> xmlProcessor = new BaseAnnotationXmlProcessor<>(apiUrlConfiguration.ORDER_QUERY, OrderQueryResponseXmlBody.class, wechatPayClientListener);
        return new OrderQueryWechatPayRequestor(xmlProcessor, wechatPayConfiguration);
    }

    /**
     * 关闭订单
     * @return CloseOrderWechatPayRequestor
     */
    public CloseOrderWechatPayRequestor closeOrderRequestor() {
        XmlProcessor<CloseOrderRequestXmlBody, CloseOrderResponseXmlBody> xmlProcessor = new BaseAnnotationXmlProcessor<>(apiUrlConfiguration.CLOSE_ORDER, CloseOrderResponseXmlBody.class, wechatPayClientListener);
        return new CloseOrderWechatPayRequestor(xmlProcessor, wechatPayConfiguration);
    }

    /**
     * 申请退款
     * @return RefundOrderWechatPayRequestor
     */
    public RefundOrderWechatPayRequestor refundRequestor() {
        XmlProcessor<RefundRequestXmlBody, RefundResponseXmlBody> xmlProcessor = new BaseAnnotationXmlProcessor<>(apiUrlConfiguration.REFUND, RefundResponseXmlBody.class, wechatPayClientListener);
        return new RefundOrderWechatPayRequestor(xmlProcessor, wechatPayConfiguration);
    }

    /**
     * 查询退款
     * @return RefundQueryWechatPayRequestor
     */
    public RefundQueryWechatPayRequestor refundQueryRequestor() {
        XmlProcessor<RefundQueryRequestXmlBody, RefundQueryResponseXmlBody> xmlProcessor = new BaseAnnotationXmlProcessor<>(apiUrlConfiguration.REFUND_QUERY, RefundQueryResponseXmlBody.class, wechatPayClientListener);
        return new RefundQueryWechatPayRequestor(xmlProcessor, wechatPayConfiguration);
    }

    /**
     * 下载对账单
     * @return WechatPayRequestor
     */
    public TableDownloadRequestor downloadBillRequestor() {
        XmlProcessor<DownloadBillRequestXmlBody, DownloadBillResponseXmlBody> xmlProcessor = new BaseAnnotationXmlProcessor<>(apiUrlConfiguration.REFUND_QUERY, DownloadBillResponseXmlBody.class, wechatPayClientListener);
        return new SimpleTableDownloadRequestor<>(xmlProcessor, wechatPayConfiguration);
    }




}
