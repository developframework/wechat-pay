package org.develop.wechatpay;

import org.develop.wechatpay.entity.UnifiedOrderRequestEntity;
import org.develop.wechatpay.entity.UnifiedOrderResponseEntity;

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
	public UnifiedOrderResponseEntity unifiedOrder(UnifiedOrderRequestEntity unifiedOrderRequestEntity);

}
