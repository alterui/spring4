package com.oyo.demo1029;

import com.google.common.collect.Lists;
import com.oyo.common.ResponseCode;
import com.oyo.demo1010.Service;
import com.oyo.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/10/29 19:07
 */
@Slf4j
public class Application {
    public static void main(String[] args) {

        String statusName = getStatusName("1-12-2");
        System.out.println(statusName);

    }

    public static String getStatusName(String statusStr) {
        if (StringUtils.isBlank(statusStr) || "0".equals(statusStr)) {
            //老数据external_sub_status默认初始化成了空字符串,特殊处理
            return null;
        }
        if (!checkValidity(statusStr, "\\d+-\\d+-\\d+")) {
            log.warn("外部子状态格式不正确");
            throw new ServiceException(ResponseCode.FAILURE.getCode(), "外部子状态格式不正确");
        }
        String[] statusArr = statusStr.split("-");
        return statusArr[statusArr.length - 1];
    }

    /**
     * 判断字符串满足指定格式 true 合法
     */
    public static boolean checkValidity(String str, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
