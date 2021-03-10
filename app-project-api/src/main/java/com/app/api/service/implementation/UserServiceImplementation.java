package com.app.api.service.implementation;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.api.dao.UserRepository;
import com.app.api.entity.User;
import com.app.api.request.CategoryRequest;
import com.app.api.request.RegistrationRequest;
import com.app.api.security.Message;
import com.app.api.service.UserService;
import com.app.api.service.util.UserServiceUtil;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private UserServiceUtil userUtil;
	
	@Autowired
	private Message message;
	
	@Autowired
	private BCryptPasswordEncoder cryptPasswordEncoder; 
	
	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public String createUser(RegistrationRequest request) {
		String result = userUtil.createUserDataValidation(request);
		if(!result.equalsIgnoreCase(message.SUCCESS)) {
			return result;
		}
				
		User user = new User();
		BeanUtils.copyProperties(request, user);
		user.setPassword(cryptPasswordEncoder.encode(request.getPassword()));
		
		LocalDate dateOfBirth = LocalDate.parse(request.getDateOfBirth());
		user.setDateOfBirth(dateOfBirth);
		
		userRepository.save(user);
	
		return message.USER_CREATED_WITH_SUCCESS_MESSAGE;
	}
	
	@Override
	public String addTaskCategory(Long id, CategoryRequest request) {
		if(!userRepository.existsById(id)) {
			return message.ID_DOESNT_EXIST_MESSAGE;
		}
		
		String correctCategoryName = userUtil.convertCategoryNameToStandard(request.getName());
		
		userRepository.addTask(id, correctCategoryName);
		
		return message.TASK_CATEGORY_ADDED_WITH_SUCCESS;
	}

	@Override
	public String deleteUser(Long id) {
		boolean exists = userRepository.existsById(id);
		if(!exists) {
			return message.ID_DOESNT_EXIST_MESSAGE;
		}
		
		userRepository.deleteById(id);
		
		return message.ID_DELETED_WITH_SUCCESS_MESSAGE;
	}
	
	@Transactional
	@Override
	public String updateUser(Long id, String firstName, String lastName, String dateOfBirth, String password) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(message.ID_DOESNT_EXIST_MESSAGE));

		String result = userUtil.updateUserDataValidation(firstName, lastName, dateOfBirth, password);
		if(!result.equalsIgnoreCase(message.SUCCESS)) {
			return result;
		}
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setDateOfBirth(LocalDate.parse(dateOfBirth));
		user.setPassword(cryptPasswordEncoder.encode(password));
		
		return message.USER_UPDATED_WITH_SUCCESS_MESSAGE;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(message.USER_NOT_FOUND_MESSAGE));
	}
}
