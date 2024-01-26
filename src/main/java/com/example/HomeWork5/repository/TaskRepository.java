package com.example.HomeWork5.repository;


import com.example.HomeWork5.model.Task;
import com.example.HomeWork5.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Поиск и получение задачи по заданному статусу
     * @param taskStatus
     * @return
     */
    List<Task> findByStatus(TaskStatus taskStatus);
}
