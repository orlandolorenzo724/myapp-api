package com.app.api.service;

import org.springframework.stereotype.Service;

import com.app.api.request.AddCategoryRequest;

@Service
public interface UserCategoryService {
	public String addCategory(Long id, AddCategoryRequest request);
}
