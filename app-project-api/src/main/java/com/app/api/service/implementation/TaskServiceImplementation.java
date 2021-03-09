package com.app.api.service.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.dao.TaskRepository;
import com.app.api.dao.UserRepository;
import com.app.api.entity.Task;
import com.app.api.entity.User;
import com.app.api.request.TaskRequest;
import com.app.api.response.UserTaskResponse;
import com.app.api.security.Message;
import com.app.api.security.validator.DateValidator;
import com.app.api.service.TaskService;

@Service
public class TaskServiceImplementation implements TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DateValidator dateValidator;
	
	@Autowired
	private Message message;
	
	@Override
	public String addTask(Long id, TaskRequest request) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(message.ID_DOESNT_EXIST_MESSAGE));
		
		boolean isStartingDateValid = dateValidator.isDateValid(request.getStartingDate());
		if(!isStartingDateValid) {
			return message.DATE_NOT_VALID_MESSAGE;
		}
		
		boolean isEndingDateValid = dateValidator.isDateValid(request.getEndingDate());
		if(!isEndingDateValid) {
			return message.DATE_NOT_VALID_MESSAGE;
		}
		
		LocalDate startingDate = LocalDate.parse(request.getStartingDate());
		LocalDate endingDate = LocalDate.parse(request.getEndingDate());
		Task task = new Task(request.getName(), request.getDescription(), startingDate, endingDate);
		task.setUser(user);
		
		taskRepository.save(task);
		
		return message.TASK_ADDED_WITH_SUCCESS;
	}

	@Override
	public List<UserTaskResponse> getTasks() {
		return taskRepository.getUserTasks();
	}

	@Override
	public String deleteTask(Long userId, Long taskId) {
		boolean checkUserId = userRepository.existsById(userId);
		if(!checkUserId) {
			return message.ID_DOESNT_EXIST_MESSAGE;
		}
		
		boolean checkTaskId = taskRepository.existsById(taskId);
		if(!checkTaskId) {
			return message.ID_DOESNT_EXIST_MESSAGE;
		}
		
		taskRepository.deleteById(taskId);
		
		return message.TASK_DELETED_WITH_SUCCESS;
	}
}
