package com.oyo.spring4.controller;

import com.alibaba.fastjson.JSON;
import com.oyo.spring4.controller.dto.CountryReq;
import com.oyo.spring4.mapper.SysUserMapper;
import com.oyo.spring4.model.Country;
import com.oyo.spring4.pageHelp.PagedResponse;
import com.oyo.spring4.po.SysRole;
import com.oyo.spring4.po.SysUser;
import com.oyo.spring4.service.CountryService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/getUserByParam")
    public List<SysUser> getUserByParam(SysUser user) {
        List<SysUser> sysRoles = sysUserMapper.selectByUser(user);
        sysRoles.stream().map(e -> e.getCreateTime());

        System.out.println(sysRoles);
        return sysRoles;
    }

    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(date);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        System.out.println(time);
    }


}
