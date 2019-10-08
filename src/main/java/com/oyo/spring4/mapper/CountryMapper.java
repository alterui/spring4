package com.oyo.spring4.mapper;

import com.oyo.spring4.model.Country;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liurui
 * @date 2019/10/8 15:49
 */
@Mapper
@Repository
public interface CountryMapper {
    List<Country> selectAll();
}
