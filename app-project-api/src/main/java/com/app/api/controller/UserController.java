package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.entity.User;
import com.app.api.request.RegistrationRequest;
import com.app.api.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping("/create")
	public String createUser(@RequestBody RegistrationRequest request) {
		return userService.createUser(request);
	}
}
