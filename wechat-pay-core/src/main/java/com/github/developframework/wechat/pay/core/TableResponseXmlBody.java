package com.github.developframework.wechat.pay.core;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TableResponseXmlBody extends ResponseXmlBody{

    protected String sourceContent;

    protected String returnCode;

    protected String returnMsg;

    public boolean isOK() {
        return returnCode == null;
    }


}
