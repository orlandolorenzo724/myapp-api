package com.app.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.entity.UserCategory;

@Repository
public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> {
	public Optional<UserCategory> findByName(String name);
}
