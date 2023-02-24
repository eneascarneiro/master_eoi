package com.example.demo.data.repository;

import com.example.demo.data.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Page<Task> findByUserId(Integer userId, Pageable pageable);

}
