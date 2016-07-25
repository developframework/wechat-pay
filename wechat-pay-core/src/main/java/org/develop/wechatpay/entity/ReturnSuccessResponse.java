package org.develop.wechatpay.entity;

import java.io.Serializable;

import org.develop.wechatpay.annotation.Entity;
import org.develop.wechatpay.annotation.SignElement;
import org.develop.wechatpay.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnSuccessResponse<T> implements Serializable {

	private static final long serialVersionUID = 433964893456293263L;

	/* 公众账号ID */
	@XmlElement("appid")
	private String appid;

	/* 商户号 */
	@XmlElement("mch_id")
	private String mchId;

	/* 设备号 */
	@XmlElement("device_info")
	private String deviceInfo;

	/* 随机字符串 */
	@XmlElement("nonce_str")
	private String nonceStr;

	/* 签名 */
	@SignElement
	@XmlElement("sign")
	private String sign;

	/* 业务结果 */
	@XmlElement("result_code")
	private String resultCode;

	/* 错误代码 */
	@XmlElement("err_code")
	private String errCode;

	/* 错误代码描述 */
	@XmlElement("err_code_des")
	private String errCodeDes;

	@Entity
	private T resultSuccessResponseInfo;

	public boolean isResultSuccess() {
		return "SUCCESS".equals(resultCode);
	}

}
