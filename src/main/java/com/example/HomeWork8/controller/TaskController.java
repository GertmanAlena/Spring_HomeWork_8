package com.example.HomeWork8.controller;

import com.example.HomeWork8.model.Task;
import com.example.HomeWork8.model.TaskStatus;
import com.example.HomeWork8.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TasksService service;

    /**
     * Добавление задачи
     * @param task
     * @return
     */
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        return service.addTask(task);
    }

    /**
     * Просмотр задач по статусу как вводить статус http://example.com/person/42/contacts
     * @param status "завершена", "в процессе", "не начата"
     * @return
     */
    @GetMapping("/status/{status}")
    public Optional<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.findByTaskStatus(status);
    }

    /**
     * Метод изменения статуса задачи
     * @param id персональный идентификатор задачи
     * @param task задача
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskByStatus(@PathVariable Long id, @RequestBody Task task)
    {
        return service.updateById(id, task);
    }

    /**
     * Удаление задачи
     * @param id персональный идентификатор задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTaskBuId(@PathVariable Long id){
//        service.publishComment(id);
        service.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Task>>findAll(){
        return service.findAll();
//        List<Task> allTasks = service.findAll();
//        System.out.println("********" + allTasks);
//        return ResponseEntity.ok().body(service.findAll());
    }
}
