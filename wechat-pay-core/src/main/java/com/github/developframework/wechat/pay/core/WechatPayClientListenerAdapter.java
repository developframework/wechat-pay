package com.github.developframework.wechat.pay.core;

import com.github.developframework.wechat.pay.http.HttpResponse;

/**
 * 客户端监听器的适配器
 */
public class WechatPayClientListenerAdapter implements WechatPayClientListener{

    @Override
    public void httpSuccess(WechatPayConfiguration configuration, HttpResponse httpResponse) {

    }

    @Override
    public void httpFailed(WechatPayConfiguration configuration, HttpResponse httpResponse) {

    }

    @Override
    public void prepareCheckSignFailed(WechatPayConfiguration configuration, HttpResponse httpResponse) {

    }
}
