/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.mpen.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mpen.api.domain.City;
import com.mpen.api.mapper.CityMapper;
import com.mpen.api.service.SampleCityService;

/**
 * @author kai
 */
@Component
public class SampleCityServiceImpl implements SampleCityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City findByState(String state) {
        return this.cityMapper.findByState(state);
    }

}
