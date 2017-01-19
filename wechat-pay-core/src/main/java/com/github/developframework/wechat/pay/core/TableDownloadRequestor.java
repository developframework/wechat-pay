package com.github.developframework.wechat.pay.core;

/**
 * 文件下载请求接口
 */
public interface TableDownloadRequestor<REQUEST extends RequestXmlBody> {

    TableResponseXmlBody request(REQUEST body, Class<? extends TableResponseXmlBody> clazz);
}
