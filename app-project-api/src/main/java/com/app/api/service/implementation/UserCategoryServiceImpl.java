package com.app.api.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.dao.UserCategoryRepository;
import com.app.api.dao.UserRepository;
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
		
		if(request == null) {
			// TODO: Handle entries
		}
		
		userCategoryUtil.convertCategoryNameToStandard(request.getName());
		
		UserCategory categoryByName = userCategoryRepository.findByName(request.getName()).orElseThrow(() -> new IllegalStateException(message.CATEGORY_NOT_FOUND_MESSAGE + request.getName()));		
		userRepository.addUserCategory(id, categoryByName.getId());
		
		return message.CATEGORY_ADDED_WITH_SUCCESS_MESSAGE;
	}
}
