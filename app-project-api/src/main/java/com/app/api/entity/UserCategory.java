package com.app.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user_category")
@Table(name = "user_category")
@Getter
@Setter
@NoArgsConstructor
public class UserCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long id;
	private String name;
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "app_user_category", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	public UserCategory(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void addUser(User user) {
		if(users == null) {
			users = new ArrayList<>();
		}
		
		users.add(user);
	}
}
