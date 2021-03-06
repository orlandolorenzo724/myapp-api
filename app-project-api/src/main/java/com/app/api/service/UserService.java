package com.app.api.service;

import org.springframework.stereotype.Service;

import com.app.api.request.RegistrationRequest;

@Service
public interface UserService {
	public String createUser(RegistrationRequest request);
}
