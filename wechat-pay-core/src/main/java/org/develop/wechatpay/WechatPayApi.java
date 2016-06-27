package org.develop.wechatpay;

import org.develop.wechatpay.entity.OrderQueryInfo;
import org.develop.wechatpay.entity.OrderQueryRequestEntity;
import org.develop.wechatpay.entity.UnifiedOrderInfo;
import org.develop.wechatpay.entity.UnifiedOrderRequestEntity;
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
	public WechatEntity<UnifiedOrderInfo> unifiedOrder(UnifiedOrderRequestEntity unifiedOrderRequestEntity);

	/**
	 * 查询订单
	 * 
	 * @param orderQueryRequestEntity
	 * @return
	 */
	public WechatEntity<OrderQueryInfo> orderQuery(OrderQueryRequestEntity orderQueryRequestEntity);

}
