package com.oyo.spring4.mapper;

import com.oyo.spring4.po.SysRolePrivilege;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRolePrivilegeMapper {
    int insert(SysRolePrivilege record);

    int insertSelective(SysRolePrivilege record);
}