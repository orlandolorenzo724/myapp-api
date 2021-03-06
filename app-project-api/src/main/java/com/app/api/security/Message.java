package com.app.api.security;

import org.springframework.stereotype.Component;

@Component
public class Message {
	public final String EMAIL_ALREADY_EXISTS_MESSAGE = "Email already exists!";
	public final String USER_NOT_FOUND_MESSAGE = "User not found!";
	public final String USER_CREATED_WITH_SUCCESS_MESSAGE = "User was created with success!";
}
