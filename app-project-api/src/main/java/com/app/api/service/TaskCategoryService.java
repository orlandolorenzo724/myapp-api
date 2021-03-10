package com.app.api.service;

import java.util.List;

import com.app.api.request.CategoryRequest;
import com.app.api.response.TaskCategoryResponse;

public interface TaskCategoryService {
	public String addTaskCategory(Long userId, CategoryRequest request);
	public List<TaskCategoryResponse> getTasks(Long userId);
}	
