package com.oyo.demo1016;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OTAEnum {

    MEI_TUAN(1,"美团")
    ,;
    private final int id;
    private final String desc;
}
