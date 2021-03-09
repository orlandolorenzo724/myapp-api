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
	public String addTask(@PathVariable("id") Long userId, @RequestBody TaskRequest request) {
		return taskService.addTask(userId, request);
	}
	
	@PutMapping("/update/{taskId}")
	public String updateTask(@PathVariable("id") Long userId, @PathVariable("taskId") Long taskId, @RequestParam(required = false) String name, @RequestParam(required = false) String description, @RequestParam(required = false) String startingDate, @RequestParam(required = false) String endingDate) {
		return taskService.updateTask(userId, taskId, name, description, startingDate, endingDate);
	}
	
	@DeleteMapping("/delete/{taskId}")
	public String deleteTask(@PathVariable("id") Long userId, @PathVariable("taskId") Long taskId) {
		return taskService.deleteTask(userId, taskId);
	}
}
