package com.oyo.spring4.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.oyo.spring4.SysUserVO;
import com.oyo.spring4.aop.ExceptionCatch;
import com.oyo.spring4.client.Animal;
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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    //@Qualifier("dog")
    private Animal animal;


    @PostMapping("/getCountry")
    //@ExceptionCatch
    public PagedResponse<Country> getCountry(CountryReq req) {
        log.info("com.oyo.spring4.controller.CountryController.getCountry param={}", JSON.toJSONString(req));


        try {
            Assert.notNull(req.getPageNum(),"参数不能为空");
            PagedResponse<Country> response = countryService.selectAll(req);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


    @GetMapping(value = "/getUser/userId/{userId}/username/{userName}")
    public List<SysRole> getUser(@PathVariable Long userId,@PathVariable String userName) {
        System.out.println(userId+userName);
        List<SysRole> sysRoles = sysUserMapper.selectRoleByUserId(userId, userName);
        System.out.println(sysRoles);
        return sysRoles;

    }



    @GetMapping("/getAnimal")
    public void Dog() {
        System.out.println("=====================aaaaaaaaaaaaaaaaaaaaaaa===============");
        int i = 9;
        int m = i / 0;

        animal.eat();
    }



    @GetMapping("/getUserByParam")

    public List<SysUser> getUserByParam(SysUser user) {

        List<SysUser> list = new ArrayList<>();
        list.add(user);
        return list;

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
        BeanUtils.copyProperties(sysUser, sysUser);

        if (sysUser == null) {
            sysUser = new SysUser();
        }

        System.out.println(sysUser.getCreateTime());
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


    @GetMapping("/updateByMap")
    @ExceptionCatch
    public Integer updateByMap() {


        Map<String, Object> map = Maps.newHashMap();
        map.put("id", 1L);
        map.put("user_password", "123123");

        Integer count = sysUserMapper.updateByMap(map);

        if (Objects.isNull(count)) {
            return 0;
        }
        System.out.println(count.intValue());
        return count;
    }

    @GetMapping("/updateByPrimaryKeySelective")
    public Integer updateByPrimaryKeySelective() {
        SysUser user = SysUser.builder().id(1L).userEmail("123123123@qq.com").build();
        int result = sysUserMapper.updateByPrimaryKeySelective(user);
        System.out.println(result);
        return result;
    }

    @PostMapping("/updateByPrimaryKeySelective")
    public String update(@RequestBody List<Long> longList) {
        StringBuilder stringBuilder = new StringBuilder();
        longList.forEach(e -> {
            stringBuilder.append(e);
        });

        return stringBuilder.toString();

    }



}
