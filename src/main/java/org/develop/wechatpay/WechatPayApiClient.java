package org.develop.wechatpay;

import org.develop.wechatpay.entity.UnifiedOrderRequestEntity;
import org.develop.wechatpay.entity.UnifiedOrderResponseEntity;
import org.develop.wechatpay.utils.Assert;
import org.develop.wechatpay.utils.PropertyUtils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 微信支付客户端
 * 
 * @author qiuzhenhao
 *
 */
@Slf4j
public class WechatPayApiClient extends ApiRequestor implements WechatPayApi {

	@Getter
	private WechatConfiguration wechatConfiguration;
	@Getter
	private APIURL apiurl;

	public WechatPayApiClient(WechatConfiguration wechatConfiguration) {
		Assert.nonNull(wechatConfiguration, "wechatPayConfiguration must not null!");
		Assert.nonBlank(wechatConfiguration.getAppid(), "appid is required!");
		Assert.nonBlank(wechatConfiguration.getMchId(), "mchId is required!");
		this.wechatConfiguration = wechatConfiguration;
		this.apiurl = PropertyUtils.readProperties("/wechat-pay-api.properties", APIURL.class);
	}

	@Override
	public UnifiedOrderResponseEntity unifiedOrder(UnifiedOrderRequestEntity unifiedOrderRequestEntity) {
		log.debug("client deal unified order");
		return super.api(wechatConfiguration, apiurl.UNIFIED_ORDER, unifiedOrderRequestEntity, UnifiedOrderResponseEntity.class);
	}
}
