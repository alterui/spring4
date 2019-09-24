package com.oyo.exception;

import lombok.*;

/**
 * @author liurui
 * @date 2019/9/23 11:01
 */

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ServiceException extends RuntimeException {

    private String code;

    @NonNull
    private String msg;

    private final  String value;

}
