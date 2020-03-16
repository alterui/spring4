package com.lr.api.controller;

import com.lr.api.bean.User;
import com.lr.api.common.BaseResponse;
import com.lr.api.common.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author liurui
 * @date 2020/3/9 22:13
 */
@RestController
@Slf4j
public class IndexController {

    @RequestMapping("/hi")
    public BaseResponse getIndex(@Valid User user, BindingResult bindingResult) {
        int i = 10 /0;

        return BaseResponse.success("success");
    }


}
