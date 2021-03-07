package com.app.api.security;

import org.springframework.stereotype.Component;

@Component
public class Message {
	public final String ID_DELETED_WITH_SUCCESS_MESSAGE = "User deleted with success!";
	public final String EMAIL_ALREADY_EXISTS_MESSAGE = "Email already exists!";
	public final String USER_NOT_FOUND_MESSAGE = "User not found!";
	public final String USER_CREATED_WITH_SUCCESS_MESSAGE = "User was created with success!";
	public final String USER_UPDATED_WITH_SUCCESS_MESSAGE = "User updated with success!";
	public final String EMAIL_NOT_VALID_MESSAGE = "Email is not valid!";
	public final String ID_DOESNT_EXIST_MESSAGE = "Id doesn't exist";
	public final String DATE_NOT_VALID_MESSAGE = "Date is not valid!";
	public final String FIRST_NAME_NOT_VALID_MESSAGE = "First name is not valid!";
	public final String LAST_NAME_NOT_VALID_MESSAGE = "Last name is not valid!";
	public final String PASSWORD_NOT_VALID_MESSAGE = "Password not valid";
	
	public final String SUCCESS = "SUCCESS";
}
