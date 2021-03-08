package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.dto.UserCategoryDto;
import com.app.api.request.AddCategoryRequest;
import com.app.api.service.UserCategoryService;

@RestController
@RequestMapping("/users/{id}/category")
public class UserCategoryController {
	@Autowired
	private UserCategoryService userService;
	
	@GetMapping
	public List<UserCategoryDto> getUserCategories(@PathVariable("id") Long id){
		return userService.getUserCategories(id);
	}
	
	@PostMapping("/add")
	public String addCategory(@PathVariable("id") Long id, @RequestBody AddCategoryRequest request) {
		return userService.addCategory(id, request);
	}
}
