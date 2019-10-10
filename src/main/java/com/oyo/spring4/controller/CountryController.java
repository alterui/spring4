package com.oyo.spring4.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.oyo.spring4.SysUserVO;
import com.oyo.spring4.aop.ExceptionCatch;
import com.oyo.spring4.controller.dto.CountryReq;
import com.oyo.spring4.mapper.SysUserMapper;
import com.oyo.spring4.model.Country;
import com.oyo.spring4.pageHelp.PagedResponse;
import com.oyo.spring4.po.SysRole;
import com.oyo.spring4.po.SysUser;
import com.oyo.spring4.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liurui
 * @date 2019/10/8 15:57
 */
@RestController
@Slf4j
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
    public List<SysRole> getUser(Long userId, String userName) {
        List<SysRole> sysRoles = sysUserMapper.selectRoleByUserId(userId, userName);
        System.out.println(sysRoles);
        return sysRoles;
    }

    @GetMapping("/getUserByParam")
    @ExceptionCatch
    public List<SysUserVO> getUserByParam(SysUser user) {
        //log.info("CountryController.getUserByParam param is={}", JSON.toJSONString(user));

        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<SysUser> sysUsers = sysUserMapper.selectByUser(user);

        List<SysUserVO> sysUserList = new ArrayList<>();
        sysUsers.forEach(sysUser -> {
            SysUserVO sysUserVO = new SysUserVO();
            BeanUtils.copyProperties(sysUser, sysUserVO);
            sysUserVO.setCreateTime(simpleDateFormat.format(sysUser.getCreateTime()));
            sysUserList.add(sysUserVO);
        });

        return sysUserList;
    }

    @GetMapping("/getUserByParams")
    @ExceptionCatch
    public List<SysUserVO> getUserByParams(SysUser user) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<SysUser> sysUsers = sysUserMapper.selectByUsers(user);

        List<SysUserVO> sysUserList = Lists.newArrayList();
        sysUsers.forEach(sysUser -> {
            SysUserVO sysUserVO = new SysUserVO();
            BeanUtils.copyProperties(sysUser, sysUserVO);
            sysUserVO.setCreateTime(simpleDateFormat.format(sysUser.getCreateTime()));
            sysUserList.add(sysUserVO);
        });

        return sysUserList;
    }


    @GetMapping("/selectByIdOrUserName")
    @ExceptionCatch
    public SysUser selectByIdOrUserName(SysUser user) {
        SysUser sysUser = sysUserMapper.selectByIdOrUserName(user);
        return sysUser;
    }

}
