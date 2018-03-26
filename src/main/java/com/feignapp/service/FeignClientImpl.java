package com.feignapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.feignapp.model.User;

@Component
public class FeignClientImpl implements FeignUserClient {

	@Override
	public List<User> findAll() {

		return Arrays.asList(new User("default", "default", 1));
	}

	@Override
	public User findOne(int hotelId) {
		return new User("dummy", "no email", 1);
	}

	@Override
	public List<User> findUsersByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
