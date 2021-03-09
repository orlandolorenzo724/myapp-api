package com.app.api.response;

import java.time.LocalDate;

public interface UserTaskResponse {
	public String getUserEmail();
	public String getTaskName();
	public String getTaskDescription();
	public LocalDate getStartingDate();
	public LocalDate getEndingDate();
}