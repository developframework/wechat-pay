package com.github.developframework.wechat.pay.exception;

/**
 * 预签名验证失败异常
 */
public class PrepareCheckSignFailedException extends CheckSignFailedException{

    public PrepareCheckSignFailedException() {
    }

    public PrepareCheckSignFailedException(String sign, String targetSign) {
        super(sign, targetSign);
    }
}
