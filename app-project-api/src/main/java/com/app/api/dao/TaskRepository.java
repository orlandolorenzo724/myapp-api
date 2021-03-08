package com.app.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.api.entity.Task;
import com.app.api.response.UserTaskResponse;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	
	@Query(value = "SELECT au.email AS userEmail, t.name AS taskName, t.description AS taskDescription,"
			+ " t.starting_date AS startingDate, t.ending_date AS endingDate"
			+ " FROM task AS t"
			+ " JOIN app_user AS au"
			+ " ON t.user_id = au.user_id", nativeQuery = true)
	public List<UserTaskResponse> getUserTasks();
}
