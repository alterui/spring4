package com.lr.coding.spring5;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author liurui
 * @date 2020/1/10 16:45
 */
@Service
public class SpringService {

    public SpringService(){
        System.out.println("SpringService 的构造方法执行啦");
    }

    public int getNum() {
        return 1;
    }
}
