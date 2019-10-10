package com.oyo.spring4.mapper;

import com.oyo.spring4.po.SysRole;
import com.oyo.spring4.po.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    SysUser selectByIdOrUserName(SysUser sysUser);

}