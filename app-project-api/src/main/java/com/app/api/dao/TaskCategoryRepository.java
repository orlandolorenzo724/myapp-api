package com.app.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.entity.TaskCategory;

@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Long>{

}
