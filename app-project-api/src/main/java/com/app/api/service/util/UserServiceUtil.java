package com.app.api.service.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.dao.UserRepository;
import com.app.api.entity.User;
import com.app.api.request.RegistrationRequest;
import com.app.api.security.Message;
import com.app.api.security.validator.DateValidator;
import com.app.api.security.validator.EmailValidator;
import com.app.api.security.validator.NameValidator;
import com.app.api.security.validator.PasswordValidator;

@Component
public class UserServiceUtil {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Message message;
	
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private DateValidator dateValidator;
	
	@Autowired
	private NameValidator nameValidator;
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	public String createUserDataValidation(RegistrationRequest request) {
		boolean isEmailValid = emailValidator.isEmailValid(request.getEmail());
		if(!isEmailValid) {
			return message.EMAIL_NOT_VALID_MESSAGE;
		}
		
		boolean isPasswordValid = passwordValidator.isPasswordValid(request.getPassword());
		if(!isPasswordValid) {
			return message.PASSWORD_NOT_VALID_MESSAGE;
		}
		
		boolean isDateValid = dateValidator.isDateValid(request.getDateOfBirth());
		if(!isDateValid) {
			return message.DATE_NOT_VALID_MESSAGE;
		}
		
		boolean isFirstNameValid = nameValidator.isNameValid(request.getFirstName());
		if(!isFirstNameValid) {
			return message.FIRST_NAME_NOT_VALID_MESSAGE;
		}
		
		boolean isLastNameValid = nameValidator.isNameValid(request.getLastName());
		if(!isLastNameValid) {
			return message.LAST_NAME_NOT_VALID_MESSAGE;
		}
		
		Optional<User> userByEmail = userRepository.findByEmail(request.getEmail());
		if(userByEmail.isPresent()) {
			return message.EMAIL_ALREADY_EXISTS_MESSAGE;
		}
		
		return message.SUCCESS;
	}
	
	public String updateUserDataValidation(String firstName, String lastName, String dateOfBirth, String password) {		
		boolean isFirstNameValid = nameValidator.isNameValid(firstName);
		if(!isFirstNameValid) {
			return message.FIRST_NAME_NOT_VALID_MESSAGE;
		}
		
		boolean isLastNameValid = nameValidator.isNameValid(lastName);
		if(!isLastNameValid) {
			return message.LAST_NAME_NOT_VALID_MESSAGE;
		}
		
		boolean isDateValid = dateValidator.isDateValid(dateOfBirth);
		if(!isDateValid) {
			return message.DATE_NOT_VALID_MESSAGE;
		}
		
		boolean isPasswordValid = passwordValidator.isPasswordValid(password);
		if(!isPasswordValid) {
			return message.PASSWORD_NOT_VALID_MESSAGE;
		}
		
		return message.SUCCESS;	
	}
}