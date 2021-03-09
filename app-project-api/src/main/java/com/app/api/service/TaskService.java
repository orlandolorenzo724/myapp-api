package com.app.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.api.request.TaskRequest;
import com.app.api.response.UserTaskResponse;

@Service
public interface TaskService {
	public String addTask(Long id, TaskRequest request);
	public List<UserTaskResponse> getTasks();
	public String deleteTask(Long userId, Long taskId);
	public String updateTask(Long userId, Long taskId, String name, String description, String startingDate, String endingDate);
}
