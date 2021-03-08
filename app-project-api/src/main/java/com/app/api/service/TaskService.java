package com.app.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.api.entity.Task;
import com.app.api.request.TaskRequest;
import com.app.api.response.UserTaskResponse;

@Service
public interface TaskService {
	public String addTask(Long id, TaskRequest request);
	public List<UserTaskResponse> getTasks();
}
