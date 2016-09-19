package com.github.developframework.wechat.pay.core;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@Getter
public abstract class RequestXmlBody implements Serializable{

    /* 公众账号ID */
    @XmlElement(name = "appid")
    private String appid;

    /* 商户号 */
    @XmlElement(name = "mch_id")
    private String mchId;

    /* 随机字符串 */
    @XmlElement(name = "nonce_str", required = true)
    private String nonceStr;

    protected void setAppid(String appid) {
        this.appid = appid;
    }

    protected void setMchId(String mchId) {
        this.mchId = mchId;
    }

    protected void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }
}
