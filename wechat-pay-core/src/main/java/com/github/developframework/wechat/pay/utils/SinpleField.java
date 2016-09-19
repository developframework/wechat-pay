package com.github.developframework.wechat.pay.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.UnsupportedEncodingException;

@Getter
@Setter
@AllArgsConstructor
public class SinpleField {

    private String fieldName;

    private Object value;

    @Override
    public String toString() {
        return String.format("%s=%s", fieldName, value.toString());
    }
}
