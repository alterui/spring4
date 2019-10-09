package com.oyo.spring4.controller;

import com.alibaba.fastjson.JSON;
import com.oyo.spring4.controller.dto.CountryReq;
import com.oyo.spring4.mapper.SysUserMapper;
import com.oyo.spring4.model.Country;
import com.oyo.spring4.pageHelp.PagedResponse;
import com.oyo.spring4.po.SysRole;
import com.oyo.spring4.service.CountryService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liurui
 * @date 2019/10/8 15:57
 */
@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private SysUserMapper sysUserMapper;


    @GetMapping("/getCountry")
    public PagedResponse<Country> getCountry(CountryReq req) {
        PagedResponse<Country> response = countryService.selectAll(req);
        return response;
    }


    @GetMapping("/getUser")
    public List<SysRole> getUser(Long userId,String userName) {
        List<SysRole> sysRoles = sysUserMapper.selectRoleByUserId(userId,userName);
        System.out.println(sysRoles);
        return sysRoles;
    }


}
