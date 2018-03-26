package com.feignapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.feignapp.model.User;


@FeignClient(value="user-service", fallback= FeignClientImpl.class)
public interface FeignUserClient {
	
	@RequestMapping(value = "/all-users", produces = "application/json")
	public List<User> findAll() ;
	
	@RequestMapping(value = "/users-by-city/{city}")
	public List<User> findUsersByCity(@PathVariable("city") String city) ;
	

	@RequestMapping(value = "/one-user/{id}")
	public User findOne(@PathVariable("id") int userId);

	

}
