package com.example.HomeWork5.controller;

import com.example.HomeWork5.model.Task;
import com.example.HomeWork5.model.TaskStatus;
import com.example.HomeWork5.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TasksService tasksService;

    /**
     * Добавление задачи
     * @param task
     * @return
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        return tasksService.createTask(task);
    }

    /**
     * Просмотр задач по статусу как вводить статус http://example.com/person/42/contacts
     * @param status "завершена", "в процессе", "не начата"
     * @return
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return tasksService.getTasksByStatus(status);
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
        return tasksService.updateTaskByStatus(id, task);
    }

    /**
     * Удаление задачи
     * @param id персональный идентификатор задачи
     */
    @DeleteMapping("/{id}") public void deleteTaskBuId(@PathVariable Long id){
        tasksService.deleteTaskBuId(id);
    }

}
