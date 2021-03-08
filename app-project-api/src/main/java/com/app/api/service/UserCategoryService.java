package com.app.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.api.dto.UserCategoryDto;
import com.app.api.request.AddCategoryRequest;

@Service
public interface UserCategoryService {
	public String addCategory(Long id, AddCategoryRequest request);
	public List<UserCategoryDto> getUserCategories(Long id);
}
