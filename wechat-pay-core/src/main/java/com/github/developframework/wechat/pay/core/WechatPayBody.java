package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.annotation.Entity;
import com.github.developframework.wechat.pay.annotation.Sign;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Getter
@Setter
@XmlRootElement(name="xml")
@Sign("returnSuccessResponse.sign")
public class WechatPayBody<T> implements Serializable {

    /* 返回状态码 */
    @XmlElement(name = "return_code")
    private String returnCode;

    /* 返回信息 */
    @XmlElement(name = "return_msg")
    private String returnMsg;

    @Entity
    private ReturnSuccessResponse<T> returnSuccessResponse;

    public boolean isReturnSuccess() {
        return "SUCCESS".equals(returnCode);
    }

    @Getter
    @Setter
    public static class ReturnSuccessResponse<T> implements Serializable{
        /* 公众账号ID */
        @XmlElement(name = "appid")
        private String appid;

        /* 商户号 */
        @XmlElement(name = "mch_id")
        private String mchId;

        /* 设备号 */
        @XmlElement(name = "device_info")
        private String deviceInfo;

        /* 随机字符串 */
        @XmlElement(name = "nonce_str")
        private String nonceStr;

        /* 签名 */
        @XmlElement(name = "sign")
        private String sign;

        /* 业务结果 */
        @XmlElement(name = "result_code")
        private String resultCode;

        /* 错误代码 */
        @XmlElement(name = "err_code")
        private String errCode;

        /* 错误代码描述 */
        @XmlElement(name = "err_code_des")
        private String errCodeDes;

        @Entity
        private T responseXmlBody;

        public boolean isResultSuccess() {
            return "SUCCESS".equals(resultCode);
        }
    }
}
