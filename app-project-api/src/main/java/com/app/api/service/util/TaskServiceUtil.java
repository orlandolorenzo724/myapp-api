package com.app.api.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.security.Message;
import com.app.api.security.validator.DateValidator;

@Service
public class TaskServiceUtil {
	@Autowired
	private DateValidator dateValidator;
	
	@Autowired
	private Message message;
	
	public String updateTaskDataValidation(String startingDate, String endingDate) {
		boolean isStartingDateValid = dateValidator.isDateValid(startingDate);
		if(!isStartingDateValid) {
			return message.DATE_NOT_VALID_MESSAGE;
		}
		
		boolean isEndingDateValid = dateValidator.isDateValid(endingDate);
		if(!isEndingDateValid) {
			return message.DATE_NOT_VALID_MESSAGE;
		}
		
		return message.SUCCESS;
	}
	
}
