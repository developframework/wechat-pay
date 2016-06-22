package org.develop.wechatpay;

import org.develop.wechatpay.entity.UnifiedOrderRequestEntity;
import org.develop.wechatpay.entity.UnifiedOrderResponseEntity;

public interface WechatPayApi {

	/**
	 * 统一下单
	 * 
	 * @param unifiedOrderRequestEntity
	 * @return
	 */
	public UnifiedOrderResponseEntity unifiedOrder(UnifiedOrderRequestEntity unifiedOrderRequestEntity);

}
