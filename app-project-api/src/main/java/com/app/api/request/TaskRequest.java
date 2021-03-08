package com.app.api.request;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
	private String name;
	private String description;
	private String startingDate;
	private String endingDate;
}
