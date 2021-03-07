package com.app.api.security.validator;

import java.util.Calendar;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class DateValidator {
	private final Pattern DATE_REGEX = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
	
	public boolean isDateValid(String date) {		
		if(!isYearValid(date)) {
			return false;
		}
		
		return DATE_REGEX.matcher(date).matches();
	}
	
	private boolean isYearValid(String date) {
		int insertedYear = Integer.parseInt(date.substring(0, 4));
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(insertedYear > currentYear) {
			return false;
		}
		
		return true;
	}
}
