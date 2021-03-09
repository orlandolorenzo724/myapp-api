package com.app.api.security.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator {
	private final Pattern EMAIL_REGEX = Pattern.compile("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");
	
	public boolean isEmailValid(String email) {
		return EMAIL_REGEX.matcher(email).matches();
	}
}
