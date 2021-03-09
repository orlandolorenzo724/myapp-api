package com.app.api.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.dao.UserCategoryRepository;
import com.app.api.dao.UserRepository;
import com.app.api.entity.User;
import com.app.api.entity.UserCategory;
import com.app.api.request.CategoryRequest;
import com.app.api.response.UserCategoryResponse;
import com.app.api.security.Message;
import com.app.api.service.UserCategoryService;
import com.app.api.service.util.UserCategoryServiceUtil;

@Service
public class UserCategoryServiceImplementation implements UserCategoryService {
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
	public List<UserCategoryResponse> getUserCategories(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(message.ID_DOESNT_EXIST_MESSAGE));
		return userRepository.getUserCategories(id);
	}
	
	@Override
	public String addCategory(Long id, CategoryRequest request) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(message.ID_DOESNT_EXIST_MESSAGE));
		
		// Checks if user is already registered to a user category
		boolean isCategoryPresent = user.isCategoryByNamePresent(request.getName());
		if(isCategoryPresent) {
			return message.CATEGORY_IS_ALREADY_ADDED;
		}
				
		String correctCategoryName = userCategoryUtil.convertCategoryNameToStandard(request.getName());
		
		UserCategory category = userCategoryRepository.findByName(correctCategoryName).orElseThrow(() -> new IllegalStateException(message.CATEGORY_NOT_FOUND_MESSAGE + request.getName()));		
		category.setName(correctCategoryName);
		
		userRepository.addUserCategory(id, category.getId());
		
		return message.CATEGORY_ADDED_WITH_SUCCESS_MESSAGE;
	}

	@Override
	public String deleteCategory(Long userId, Long categoryId) {
		boolean checkUserId = userRepository.existsById(userId);
		if(!checkUserId) {
			return message.ID_DOESNT_EXIST_MESSAGE + " (userId)";
		}
		
		boolean checkCategoryId = userCategoryRepository.existsById(categoryId);
		if(!checkCategoryId) {
			return message.ID_DOESNT_EXIST_MESSAGE + " (categoryId)";
		}
		
		userCategoryRepository.deleteById(categoryId);
		
		return message.CATEGORY_DELETED_WITH_SUCCESS;
	}
}
