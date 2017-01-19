package com.github.developframework.wechat.pay.core;

public interface WechatPayRequestor<REQUEST extends RequestXmlBody, RESPONSE extends ResponseXmlBody> {

    WechatPayBody<RESPONSE> request(REQUEST body);
}
