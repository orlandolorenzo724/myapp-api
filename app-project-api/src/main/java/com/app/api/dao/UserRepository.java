package com.app.api.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.api.entity.User;
import com.app.api.response.TaskCategoryResponse;
import com.app.api.response.UserCategoryResponse;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findByEmail(String email);	
	
	@Modifying
	@Query(value = "INSERT INTO app_user_category(user_id, category_id) VALUES(:userId, :categoryId)", nativeQuery = true)
	@Transactional
	public void addUserCategory(@Param("userId") Long userId, @Param("categoryId") Long categoryId);
	
	@Query(value = "SELECT tc.name AS name FROM task_category AS tc"
			+ " JOIN app_user AS au ON tc.user_id = au.user_id"
			+ " WHERE au.user_id = :userId", nativeQuery = true)
	public List<TaskCategoryResponse> getTasks(@Param("userId") Long userId);
	
	@Modifying
	@Query(value = "INSERT INTO task_category(user_id, name) VALUES(:userId, :name)", nativeQuery = true)
	@Transactional
	public void addTask(@Param("userId") Long userId, @Param("name") String name);
	
	@Query(value = "SELECT au.email AS email, uc.name AS categoryName FROM app_user_category AS auc"
			+ " JOIN app_user AS au ON au.user_id = auc.user_id"
			+ " JOIN user_category AS uc ON uc.category_id = auc.category_id"
			+ " WHERE au.user_id = :id", nativeQuery = true)
	public List<UserCategoryResponse> getUserCategories(@Param("id") Long id);
}
