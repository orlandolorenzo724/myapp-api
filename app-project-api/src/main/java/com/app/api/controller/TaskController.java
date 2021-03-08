package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.request.TaskRequest;
import com.app.api.response.UserTaskResponse;
import com.app.api.service.TaskService;

@RequestMapping("/users/{id}/task")
@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<UserTaskResponse> getTasks() {
		return taskService.getTasks();
	}
	
	@PostMapping("/add")
	public String addTask(@PathVariable("id") Long id, @RequestBody TaskRequest request) {
		return taskService.addTask(id, request);
	}
}
