package com.github.developframework.wechat.pay.entity;

import com.github.developframework.wechat.pay.annotation.Sign;
import com.github.developframework.wechat.pay.core.RequestXmlBody;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 统一下单请求实体类 <br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1
 *
 * @author qiuzhenhao
 */
@Getter
@Setter
@Sign
@XmlRootElement(name = "xml")
public class UnifiedOrderRequestXmlBody extends RequestXmlBody {

    /* 设备号 */
    @XmlElement(name = "device_info")
    private String deviceInfo;

    /* 签名 */
    @XmlElement(name = "sign")
    private String sign;

    /* 商品描述 */
    @XmlElement(name = "body", required = true)
    private String body;

    /* 商品详情 */
    @XmlElement(name = "detail")
    private String detail;

    /* 附加数据 */
    @XmlElement(name = "attach")
    private String attach;

    /* 商户订单号 */
    @XmlElement(name = "out_trade_no", required = true)
    private String outTradeNo;

    /* 货币类型 */
    @XmlElement(name = "fee_type")
    private FeeTypeEnum feeType;

    /* 总金额 */
    @XmlElement(name = "total_fee", required = true)
    private Integer totalFee;

    /* 终端IP */
    @XmlElement(name = "spbill_create_ip", required = true)
    private String spbillCreateIp;

    /* 交易起始时间 */
    @XmlElement(name = "time_start")
    private String timeStart;

    /* 交易结束时间 */
    @XmlElement(name = "time_expire")
    private String timeExpire;

    /* 商品标记 */
    @XmlElement(name = "goods_tag")
    private String goodsTag;

    /* 通知地址 */
    @XmlElement(name = "notify_url", required = true)
    private String notifyUrl;

    /* 交易类型 */
    @XmlElement(name = "trade_type", required = true)
    private TradeTypeEnum tradeType;

    /* 商品ID */
    @XmlElement(name = "product_id")
    private String productId;

    /* 指定支付方式 */
    @XmlElement(name = "limit_pay")
    private String limitPay;

    /* 用户标识 */
    @XmlElement(name = "openid")
    private String openid;
}
