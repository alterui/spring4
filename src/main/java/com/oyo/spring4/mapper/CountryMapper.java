package com.oyo.spring4.mapper;

import com.oyo.spring4.model.Country;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liurui
 * @date 2019/10/8 15:49
 */
@Mapper
public interface CountryMapper {
    List<Country> selectAll();
}
