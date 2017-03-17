/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.mpen.api.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mpen.api.domain.City;

/**
 * @author kai
 */
@Mapper
public interface CityMapper {

    @Select("select * from city where state = #{state}")
    City findByState(@Param("state") String state);

}
