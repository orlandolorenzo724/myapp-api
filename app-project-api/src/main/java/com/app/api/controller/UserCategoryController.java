package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.request.CategoryRequest;
import com.app.api.response.UserCategoryResponse;
import com.app.api.service.UserCategoryService;

@RestController
@RequestMapping("/users/{id}/category")
public class UserCategoryController {
	@Autowired
	private UserCategoryService userService;
	
	@GetMapping
	public List<UserCategoryResponse> getUserCategories(@PathVariable("id") Long id){
		return userService.getUserCategories(id);
	}
	
	@PostMapping("/add")
	public String addUserCategory(@PathVariable("id") Long id, @RequestBody CategoryRequest request) {
		return userService.addCategory(id, request);
	}
	
	@PutMapping("/update")
	public String updateUserCategory(@PathVariable("id") Long id, @RequestParam(required = true) String oldCategoryName, @RequestParam(required = true) String newCategoryName) {
		return userService.updateCategory(id, oldCategoryName, newCategoryName);
	}
	
	// TODO
	@DeleteMapping
	public String deleteUserCategory(@PathVariable("id") Long id, @RequestBody CategoryRequest request) {
		return userService.deleteCategory(id, request);
	}
}
