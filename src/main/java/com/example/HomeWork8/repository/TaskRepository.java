package com.example.HomeWork8.repository;


import com.example.HomeWork8.model.Task;

import com.example.HomeWork8.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Поиск и получение задачи по заданному статусу
     * @param status
     * @return
     */
    Optional<Task> findByTaskStatus(TaskStatus status);
}
