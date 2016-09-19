package com.github.developframework.wechat.pay.core;

import com.github.developframework.scanner.annotation.ScanProperties;
import com.github.developframework.scanner.annotation.ScanProperty;
import lombok.Getter;

@ScanProperties(location = "wechat-pay-api", prefix = "wechat.pay.api")
public class ApiUrlConfiguration {

    @ScanProperty(alias = "unifiedorder")
    public String UNIFIED_ORDER;

    @ScanProperty(alias = "orderquery")
    public String ORDER_QUERY;

    @ScanProperty(alias = "closeorder")
    public String CLOSE_ORDER;
}
