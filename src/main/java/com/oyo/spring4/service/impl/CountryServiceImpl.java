package com.oyo.spring4.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.oyo.spring4.controller.dto.CountryReq;
import com.oyo.spring4.mapper.CountryMapper;
import com.oyo.spring4.model.Country;
import com.oyo.spring4.pageHelp.PagedResponse;
import com.oyo.spring4.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liurui
 * @date 2019/10/8 16:00
 */

@Service
public class CountryServiceImpl implements CountryService  {
    @Resource
    private CountryMapper countryMapper;

    @Override
    public PagedResponse<Country> selectAll(CountryReq req) {

        Page<Country> page = PageHelper.startPage(req.getPageNum(), req.getPageSize(), true);
        List<Country> countries = countryMapper.selectAll();
        PagedResponse<Country> response = new PagedResponse<>(req.getPageNum(), req.getPageSize(), page.getTotal());
        response.setResult(countries);
        return response;

    }
}
