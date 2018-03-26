package com.feignapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.feignapp.model.User;
import com.feignapp.service.FeignUserClient;

@RestController
public class FeignUserController {

	@Autowired
	private FeignUserClient feignClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	
	@RequestMapping(value="/feign-users", produces="application/json")
	public List<User> findAll(){
		List<User> userList = feignClient.findAll();
		//System.out.println(".........URI PORT......"+loadBalancerClient.choose("user-service").getPort());
		return userList;
	}
	
	
	@RequestMapping(value="/feign-users/{userid}", produces="application/json")
	public User findById(@PathVariable("userid") int id){
		User user = feignClient.findOne(id);
		return user;
	}
	
}
