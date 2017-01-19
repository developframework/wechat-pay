package com.github.developframework.wechat.pay.entity;

import com.github.developframework.wechat.pay.core.ResponseXmlBody;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;

/**
 * 统一下单回复实体
 */
@Getter
@Setter
public class UnifiedOrderResponseXmlBody extends ResponseXmlBody {

    /* 交易类型 */
    @XmlElement(name = "trade_type")
    private String tradeType;

    /* 预支付交易会话标识 */
    @XmlElement(name = "prepay_id")
    private String prepayId;

    /* 二维码链接 */
    @XmlElement(name = "code_url")
    private String codeUrl;
}
