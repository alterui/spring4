package com.oyo.spring4.demo1008;

import org.springframework.stereotype.Component;

/**
 * @author liurui
 * @date 2019/10/8 11:42
 */
@Component
public class APP {
    void get() {
        PagedResponse pagedResponse = new PagedResponse(-1, -1, -1L);
        System.out.println(pagedResponse);
    }
}
