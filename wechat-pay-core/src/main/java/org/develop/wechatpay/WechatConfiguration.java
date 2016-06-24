package org.develop.wechatpay;

import org.develop.wechatpay.annotation.Property;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 配置
 * 
 * @author qiuzhenhao
 *
 */
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

	@Property(key = "wechat.info.api_key")
	private String apiKey;

	/* 日志打印XML美化 */
	@Property(key = "wechat.config.xml_pretty")
	private boolean logXmlPretty;

	public WechatConfiguration(String appid, String mchId) {
		this.appid = appid;
		this.mchId = mchId;
	}

}
