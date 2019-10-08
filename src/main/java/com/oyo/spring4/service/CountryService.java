package com.oyo.spring4.service;

import com.oyo.spring4.controller.dto.CountryReq;
import com.oyo.spring4.model.Country;
import com.oyo.spring4.pageHelp.PagedResponse;

import java.util.List;

/**
 * @author liurui
 * @date 2019/10/8 15:58
 */
public interface CountryService {
    PagedResponse<Country> selectAll(CountryReq req);
}
