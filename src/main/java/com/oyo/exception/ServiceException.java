package com.oyo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author liurui
 * @date 2019/9/23 11:01
 */

@Data
@Builder
@AllArgsConstructor
public class ServiceException extends RuntimeException {
    private String code;
    private String msg;

}
