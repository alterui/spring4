package com.oyo.spring4.mapper;

import com.oyo.spring4.po.SysPrivilege;
import org.springframework.stereotype.Repository;

@Repository
public interface SysPrivilegeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysPrivilege record);

    int insertSelective(SysPrivilege record);

    SysPrivilege selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysPrivilege record);

    int updateByPrimaryKey(SysPrivilege record);
}