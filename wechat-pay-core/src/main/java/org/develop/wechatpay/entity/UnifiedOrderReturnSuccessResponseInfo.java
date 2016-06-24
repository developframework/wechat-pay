package org.develop.wechatpay.entity;

import org.develop.wechatpay.annotation.Condition;
import org.develop.wechatpay.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnifiedOrderReturnSuccessResponseInfo {

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

	@Condition(element = "result_code", value = "SUCCESS")
	private UnifiedOrderResultSuccessResponseInfo resultSuccessResponseInfo;

	public boolean isResultSuccess() {
		return "SUCCESS".equals(resultCode);
	}

}
