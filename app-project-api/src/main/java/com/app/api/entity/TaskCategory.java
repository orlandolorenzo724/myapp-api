package com.app.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "task_category")
@Table(name = "task_category")
@Getter
@Setter
@NoArgsConstructor
public class TaskCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_category_id")
	private Long id;
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "taskCategory")
	private List<Task> tasks;
	
	public TaskCategory(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
