package com.example.HomeWork8.controller;

import com.example.HomeWork8.model.Task;
import com.example.HomeWork8.model.TaskStatus;
import com.example.HomeWork8.repository.TaskRepository;
import com.example.HomeWork8.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;
    private final TasksService service;

    /**
     * Добавление задачи
     * @param task
     * @return
     */
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        task.setDateOfCreation(LocalDateTime.now());
        task.setTaskStatus(TaskStatus.NOT_STARTED);
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.CREATED);
    }

    /**
     * Просмотр задач по статусу как вводить статус http://example.com/person/42/contacts
     * @param status "завершена", "в процессе", "не начата"
     * @return
     */
    @GetMapping("/status/{status}")
    public Optional<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskRepository.findByTaskStatus(status);
    }

    /**
     * Метод изменения статуса задачи
     * @param id персональный идентификатор задачи
     * @param task задача
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskByStatus(
            @PathVariable Long id, @RequestBody Task task)
    {
        Task taskUpdateStatus = taskRepository.findById(id).orElse(null);
        if(taskUpdateStatus != null){
            taskUpdateStatus.setTaskStatus(task.getTaskStatus());
            return new ResponseEntity<>(taskRepository.save(taskUpdateStatus), HttpStatus.CREATED);
        } else {
            return null;
        }

    }

    /**
     * Удаление задачи
     * @param id персональный идентификатор задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTaskBuId(@PathVariable Long id){
        service.publishComment(id);
        taskRepository.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
//        return taskRepository.findAll();
        return service.findAll();
    }
}
