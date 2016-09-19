package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.http.HttpResponse;

import java.io.Serializable;

/**
 * 微信支付客户端监听器
 */
public interface WechatPayClientListener{

    /**
     * http请求成功回调
     * @param configuration
     * @param httpResponse
     */
    void httpSuccess(WechatPayConfiguration configuration, HttpResponse httpResponse);

    /**
     * http请求失败回调
     * @param configuration
     * @param httpResponse
     */
    void httpFailed(WechatPayConfiguration configuration, HttpResponse httpResponse);

    /**
     * 预校验失败回调
     * @param configuration
     * @param httpResponse
     */
    void prepareCheckSignFailed(WechatPayConfiguration configuration, HttpResponse httpResponse);

}
