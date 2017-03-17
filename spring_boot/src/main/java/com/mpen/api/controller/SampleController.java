/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.mpen.api.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpen.api.domain.City;
import com.mpen.api.service.CacheServiceInterface;
import com.mpen.api.service.SampleCityService;

/**
 * @author kai
 *
 */
@RestController
public class SampleController {
	@Autowired
	private SampleCityService sampleCityService;
	@Autowired
	private CacheServiceInterface ucacheService;

	@GetMapping("/async")
	public String helloWorldAsync() {

		City findByState = sampleCityService.findByState("CA");
		//ucacheService.put("aaa", "b", findByState, 1000 * 60 * 60);
		/*System.out.println("查询");
		//findByState = (City) ucacheService.get("aaa", "b");
		if (findByState != null) {
			System.out.println(findByState);
			System.out.println("缓存");
		}*/
		return "async: " + findByState;

	}
}
