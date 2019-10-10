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
import java.util.Objects;

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

    @GetMapping("/selectByIdList")
    @ExceptionCatch
    public List<SysUser> selectByIdList() {
        List<Long> list = Lists.newArrayList();
        list.add(1L);
        list.add(55L);
        List<SysUser> sysUserList = sysUserMapper.selectByIdList(list);
        return sysUserList;
    }

    @GetMapping("/insertUser")
    public Integer insertUser() {

        List<SysUser> list = Lists.newArrayList();

        SysUser user1 = new SysUser();
        user1.setUserPassword("1234");
        user1.setUserInfo("test");
        user1.setHeadImg(null);
        user1.setUserName("alter");

        SysUser user2 = new SysUser();
        user2.setUserEmail("4r2342342@163.com");


        SysUser user3 = new SysUser();
        list.add(user3);
        //list.add(user2);
        Integer count = sysUserMapper.insertList(list);

        if (Objects.isNull(count)) {
            return 0;
        }
        System.out.println(count.intValue());
        return count;
    }

}
