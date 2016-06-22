package org.develop.wechatpay.entity;

import org.develop.wechatpay.annotation.BindingConverter;
import org.develop.wechatpay.annotation.Condition;
import org.develop.wechatpay.annotation.XmlElement;
import org.develop.wechatpay.converter.UnifiedOrderResponseXmlConverter;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一下单响应实体类 <br/>
 * 官方文档：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1
 * 
 * @author qiuzhenhao
 *
 */
@Getter
@Setter
@BindingConverter(UnifiedOrderResponseXmlConverter.class)
public class UnifiedOrderResponseEntity {

	/* 返回状态码 */
	@XmlElement("return_code")
	private String returnCode;

	/* 返回信息 */
	@XmlElement("return_msg")
	private String returnMsg;

	@Condition(element = "return_code", value = "SUCCESS")
	private ReturnSuccessResponseInfo returnSuccessResponseInfo;

	public boolean isReturnSuccess() {
		return "SUCCESS".equals(returnCode);
	}

	@Getter
	@Setter
	public class ReturnSuccessResponseInfo {

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
		private ResultSuccessResponseInfo resultSuccessResponseInfo;

		public boolean isResultSuccess() {
			return "SUCCESS".equals(resultCode);
		}

		@Getter
		@Setter
		public class ResultSuccessResponseInfo {

			/* 交易类型 */
			@XmlElement("trade_type")
			private String tradeType;

			/* 预支付交易会话标识 */
			@XmlElement("prepay_id")
			private String prepayId;

			/* 二维码链接 */
			@XmlElement("code_url")
			private String codeUrl;
		}
	}
}
