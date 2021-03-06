package com.app.api.service.implementation;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.dao.UserRepository;
import com.app.api.entity.User;
import com.app.api.request.RegistrationRequest;
import com.app.api.security.Message;
import com.app.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Message message;
	
	@Autowired
	
	public String createUser(RegistrationRequest request) {
		Optional<User> userByEmail = userRepository.findByEmail(request.getEmail());
		if(userByEmail.isPresent()) {
			return message.EMAIL_ALREADY_EXISTS_MESSAGE;
		}
				
		User user = new User();
		BeanUtils.copyProperties(request, user);
		
		userRepository.save(user);
	
		return message.USER_CREATED_WITH_SUCCESS_MESSAGE;
	}
}
