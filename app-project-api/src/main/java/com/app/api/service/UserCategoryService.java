package com.app.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.api.request.CategoryRequest;
import com.app.api.response.UserCategoryResponse;

@Service
public interface UserCategoryService {
	public String addCategory(Long id, CategoryRequest request);
	public List<UserCategoryResponse> getUserCategories(Long id);
	public String deleteCategory(Long id, CategoryRequest request);
	public String updateCategory(Long id, String oldCategoryName, String newCategoryName);
}
