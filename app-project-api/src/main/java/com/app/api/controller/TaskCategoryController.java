package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.request.CategoryRequest;
import com.app.api.response.TaskCategoryResponse;
import com.app.api.service.TaskCategoryService;

@RequestMapping("/users/{id}/task/category")
@RestController
public class TaskCategoryController {
	@Autowired
	private TaskCategoryService taskCategoryService;
	
	@GetMapping
	public List<TaskCategoryResponse> getTasks(@PathVariable("id") Long userId) {
		return taskCategoryService.getTasks(userId);
	}
	
	@PostMapping("/add")
	public String addTaskCategory(@PathVariable("id") Long userId, @RequestBody CategoryRequest request) {
		return taskCategoryService.addTaskCategory(userId, request);
	}
	
	@PutMapping("/update")
	public String updateTaskCategory(@PathVariable("id") Long userId, @RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(required = false) String startingDate, @RequestParam(required = false) String endingDate) {
		return taskCategoryService.updateTaskCategory(userId, name, description, startingDate, endingDate);
	}
}
