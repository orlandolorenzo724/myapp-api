package com.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.request.AddCategoryRequest;
import com.app.api.service.UserCategoryService;

@RestController
@RequestMapping("/users/{id}/category")
public class UserCategoryController {
	@Autowired
	private UserCategoryService userService;
	
	@PostMapping("/add")
	public String addCategory(@PathVariable("id") Long id, @RequestBody AddCategoryRequest request) {
		return userService.addCategory(id, request);
	}
}
