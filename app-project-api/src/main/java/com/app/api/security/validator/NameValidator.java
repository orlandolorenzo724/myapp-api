package com.app.api.security.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class NameValidator {
	private final Pattern NAME_REGEX = Pattern.compile("^[^- '](?=(?![A-Z]?[A-Z]))(?=(?![a-z]+[A-Z]))(?=(?!.*[A-Z][A-Z]))(?=(?!.*[- '][- '.]))(?=(?!.*[.][-'.]))[A-Za-z- '.]{2,}$");

	public boolean isNameValid(String name) {
		return NAME_REGEX.matcher(name).matches();
	}
}
