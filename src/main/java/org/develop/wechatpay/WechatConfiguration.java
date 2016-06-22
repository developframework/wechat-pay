package org.develop.wechatpay;

import org.develop.wechatpay.annotation.Property;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WechatConfiguration {

	/* 公众账号ID */
	@Property(key = "wechat.info.appid")
	private String appid;

	/* 商户号 */
	@Property(key = "wechat.info.mch_id")
	private String mchId;

	/* 设备号 */
	@Property(key = "wechat.info.device_info")
	private String deviceInfo;

	/* 日志打印XML美化 */
	@Property(key = "wechat.config.xml_pretty")
	private boolean logXmlPretty;

	public WechatConfiguration(String appid, String mchId) {
		this.appid = appid;
		this.mchId = mchId;
	}

}
