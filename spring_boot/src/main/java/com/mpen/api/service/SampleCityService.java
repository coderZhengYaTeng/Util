/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.mpen.api.service;

import com.mpen.api.domain.City;

/**
 * @author kai
 */
public interface SampleCityService {
    City findByState(String state);
}
