package com.oyo.spring4.mapper;

import com.oyo.spring4.po.SysRole;
import com.oyo.spring4.po.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKeyWithBLOBs(SysUser record);

    int updateByPrimaryKey(SysUser record);

    List<SysRole> selectRoleByUserId(@Param("userId") Long userId, @Param("userName") String userName);

    List<SysUser> selectByUser(SysUser user);

    List<SysUser> selectByUsers(SysUser user);

    SysUser selectByIdOrUserName(SysUser sysUser);

    List<SysUser> selectByIdList(List<Long> idList);

    Integer insertList(List<SysUser> userList);

    Integer updateByMap(Map<String, Object> map);




}