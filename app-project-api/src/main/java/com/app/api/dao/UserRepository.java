package com.app.api.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findByEmail(String email);	
	
	@Query(value = "INSERT INTO app_user_category(user_id, category_id) VALUES(:userId, :categoryId)", nativeQuery = true)
	public String addUserCategory(@Param("userId") Long userId, @Param("categoryId") Long categoryId);
}
