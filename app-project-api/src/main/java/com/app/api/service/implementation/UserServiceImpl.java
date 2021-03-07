package com.app.api.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.api.dao.UserRepository;
import com.app.api.entity.User;
import com.app.api.request.RegistrationRequest;
import com.app.api.security.EmailValidator;
import com.app.api.security.Message;
import com.app.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Message message;
	
	@Autowired
	private EmailValidator emailValidator;
	
	@SuppressWarnings("unused")
	@Autowired
	private BCryptPasswordEncoder cryptPasswordEncoder;
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	public String createUser(RegistrationRequest request) {
		boolean isEmailValid = emailValidator.isEmailValid(request.getEmail());
		if(!isEmailValid) {
			return message.EMAIL_NOT_VALID_MESSAGE;
		}
		
		Optional<User> userByEmail = userRepository.findByEmail(request.getEmail());
		if(userByEmail.isPresent()) {
			return message.EMAIL_ALREADY_EXISTS_MESSAGE;
		}
		
		User user = new User();
		BeanUtils.copyProperties(request, user);
		user.setPassword(cryptPasswordEncoder.encode(request.getPassword()));
		
		userRepository.save(user);
	
		return message.USER_CREATED_WITH_SUCCESS_MESSAGE;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(message.USER_NOT_FOUND_MESSAGE));
	}
}
