package com.github.developframework.wechat.pay.entity;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 支付结果通知响应实体<br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_7
 *
 * @author qiuzhenhao
 */
@Getter
@Setter
@XmlRootElement(name = "xml")
public class WechatPayNotifyResponseBody implements Serializable {

    /* 返回状态码 */
    @XmlElement(name = "return_code")
    private String returnCode;

    /* 返回信息 */
    @XmlElement(name = "return_msg")
    private String returnMsg;
}
