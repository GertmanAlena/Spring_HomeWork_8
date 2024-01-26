package com.example.HomeWork5.controller;

import com.example.HomeWork5.model.Task;
import com.example.HomeWork5.model.TaskStatus;
import com.example.HomeWork5.repository.TaskRepository;
//import com.example.HomeWork5.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskRepository taskRepository;

    /**
     * Добавление задачи
     * @param task
     * @return
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    /**
     * Просмотр задач по статусу как вводить статус http://example.com/person/42/contacts
     * @param status "завершена", "в процессе", "не начата"
     * @return
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskRepository.findByStatus(status);
    }

    /**
     * Метод изменения статуса задачи
     * @param id персональный идентификатор задачи
     * @param task задача
     * @return
     */
    @PutMapping("/{id}") public Task updateTaskByStatus(
            @PathVariable Long id, @RequestBody Task task)
    {
        Task taskUpdateStatus = taskRepository.findById(id).orElse(null);
        if(taskUpdateStatus != null){
            taskUpdateStatus.setTaskStatus(task.getTaskStatus());
            return taskRepository.save(taskUpdateStatus);
        } else {
            return null;
        }

    }

    /**
     * Удаление задачи
     * @param id персональный идентификатор задачи
     */
    @DeleteMapping("/{id}") public void deleteTaskBuId(@PathVariable Long id){
        taskRepository.deleteById(id);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
}
