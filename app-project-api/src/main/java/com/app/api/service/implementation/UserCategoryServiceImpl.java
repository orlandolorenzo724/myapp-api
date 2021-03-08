package com.app.api.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.dao.UserCategoryRepository;
import com.app.api.dao.UserRepository;
import com.app.api.dto.UserCategoryDto;
import com.app.api.entity.User;
import com.app.api.entity.UserCategory;
import com.app.api.request.AddCategoryRequest;
import com.app.api.security.Message;
import com.app.api.service.UserCategoryService;
import com.app.api.service.util.UserCategoryServiceUtil;

@Service
public class UserCategoryServiceImpl implements UserCategoryService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserCategoryRepository userCategoryRepository;
	
	@Autowired
	private UserCategoryServiceUtil userCategoryUtil;
	
	@Autowired
	private Message message;
	
	@SuppressWarnings("unused")
	@Override
	public String addCategory(Long id, AddCategoryRequest request) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(message.ID_DOESNT_EXIST_MESSAGE));
		
		// TODO: Check if user is already registered to a user category
		
		if(request == null) {
			// TODO: Handle entries
		}
		
		String correctCategoryName = userCategoryUtil.convertCategoryNameToStandard(request.getName());
		
		UserCategory categoryByName = userCategoryRepository.findByName(correctCategoryName).orElseThrow(() -> new IllegalStateException(message.CATEGORY_NOT_FOUND_MESSAGE + request.getName()));		
		categoryByName.setName(correctCategoryName);
		
		userRepository.addUserCategory(id, categoryByName.getId());
		
		return message.CATEGORY_ADDED_WITH_SUCCESS_MESSAGE;
	}

	@Override
	public List<UserCategoryDto> getUserCategories(Long id) {
		return userRepository.getUserCategories(id);
	}
}
