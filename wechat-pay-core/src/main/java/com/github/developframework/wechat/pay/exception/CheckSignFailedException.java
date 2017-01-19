package com.github.developframework.wechat.pay.exception;

import lombok.Getter;

/**
 * 签名验证失败异常
 */
@Getter
public class CheckSignFailedException extends WechatPayException{

    protected String sign;
    protected String targetSign;

    public CheckSignFailedException() {
    }

    public CheckSignFailedException(String sign, String targetSign) {
        this.sign = sign;
        this.targetSign = targetSign;
    }
}
