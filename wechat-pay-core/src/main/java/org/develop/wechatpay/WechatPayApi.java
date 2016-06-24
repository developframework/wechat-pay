package org.develop.wechatpay;

import org.develop.wechatpay.entity.UnifiedOrderRequestEntity;
import org.develop.wechatpay.entity.UnifiedOrderReturnSuccessResponseInfo;
import org.develop.wechatpay.entity.WechatEntity;

/**
 * 微信支付API接口
 * 
 * @author qiuzhenhao
 *
 */
public interface WechatPayApi {

	/**
	 * 统一下单
	 * 
	 * @param unifiedOrderRequestEntity
	 * @return
	 */
	public WechatEntity<UnifiedOrderReturnSuccessResponseInfo> unifiedOrder(UnifiedOrderRequestEntity unifiedOrderRequestEntity);

}
