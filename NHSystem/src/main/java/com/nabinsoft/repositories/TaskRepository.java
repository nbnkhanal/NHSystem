package com.nabinsoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nabinsoft.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
