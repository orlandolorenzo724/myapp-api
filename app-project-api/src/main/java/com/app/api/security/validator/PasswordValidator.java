package com.app.api.security.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {
	private final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$");
	
	public boolean isPasswordValid(String password) {
		return PASSWORD_REGEX.matcher(password).matches();
	}
}
