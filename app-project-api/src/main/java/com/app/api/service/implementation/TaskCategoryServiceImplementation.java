package com.app.api.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.dao.UserRepository;
import com.app.api.request.CategoryRequest;
import com.app.api.response.TaskCategoryResponse;
import com.app.api.security.Message;
import com.app.api.service.TaskCategoryService;

@Service
public class TaskCategoryServiceImplementation implements TaskCategoryService{
	@Autowired
	private Message message;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<TaskCategoryResponse> getTasks(Long userId) {
		if(!userRepository.existsById(userId)) {
			throw new IllegalStateException(message.ID_DOESNT_EXIST_MESSAGE);
		}
		
		return userRepository.getTasks(userId);
	}
	
	@Override
	public String addTaskCategory(Long userId, CategoryRequest request) {
		return null;
	}
}
