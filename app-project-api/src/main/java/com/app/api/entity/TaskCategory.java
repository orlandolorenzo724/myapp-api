package com.app.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	public TaskCategory(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
