package com.github.developframework.wechat.pay.core;

import com.github.developframework.scanner.annotation.ScanProperties;
import com.github.developframework.scanner.annotation.ScanProperty;
import lombok.Data;

@Data
@ScanProperties(location = "wechat-pay", prefix = "wechat.pay")
public class WechatPayConfiguration {

    /* 公众账号ID */
    @ScanProperty(alias = "appid")
    private String appid;

    /* 商户号 */
    @ScanProperty(alias = "mchId")
    private String mchId;

    /* apiKey */
    @ScanProperty(alias = "apiKey")
    private String apiKey;

    /* 日志打印XML美化 */
    @ScanProperty(alias = "log.xml_pretty")
    private boolean logXmlPretty;
}
