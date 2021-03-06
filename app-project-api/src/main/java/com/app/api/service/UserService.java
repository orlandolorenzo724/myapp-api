package com.app.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.api.entity.User;
import com.app.api.request.RegistrationRequest;

@Service
public interface UserService {
	public List<User> getUsers();
	public String createUser(RegistrationRequest request);
}
