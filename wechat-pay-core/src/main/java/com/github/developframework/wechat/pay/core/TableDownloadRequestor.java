package com.github.developframework.wechat.pay.core;

/**
 * 文件下载请求接口
 */
public interface FileDownloadRequestor<REQUEST extends RequestXmlBody> {

    StreamResponseXmlBody request(REQUEST body);
}
