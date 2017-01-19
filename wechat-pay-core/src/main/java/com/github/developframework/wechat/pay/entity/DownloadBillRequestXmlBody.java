package com.github.developframework.wechat.pay.entity;

import com.github.developframework.wechat.pay.annotation.Sign;
import com.github.developframework.wechat.pay.core.RequestXmlBody;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 下载对账单请求实体类 <br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_6
 *
 * @author qiuzhenhao
 */
@Getter
@Setter
@Sign
@XmlRootElement(name = "xml")
public class DownloadBillRequestXmlBody extends RequestXmlBody{

    /* 设备号 */
    @XmlElement(name = "device_info")
    private String deviceInfo;

    /* 签名 */
    @XmlElement(name = "sign", required = true)
    private String sign;

    /* 对账单日期 */
    @XmlElement(name = "bill_date", required = true)
    private String billDate;

    /* 账单类型 */
    @XmlElement(name = "bill_type", required = true)
    private BillTypeEnum billType;
}
