package com.app.api.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.app.api.entity.User;
import com.app.api.request.RegistrationRequest;

@Service
public interface UserService extends UserDetailsService{
	public List<User> getUsers();
	public String createUser(RegistrationRequest request);
}
