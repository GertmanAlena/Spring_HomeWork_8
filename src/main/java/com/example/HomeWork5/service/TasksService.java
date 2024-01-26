package com.example.HomeWork5.service;

import com.example.HomeWork5.model.Task;
import com.example.HomeWork5.model.TaskStatus;
import com.example.HomeWork5.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TasksService {

    private final TaskRepository repository;

    /**
     * Получить список всех задач.
     * @return список задач.
     */
    public List<Task> getAllBooks(){
        return repository.findAll();
    }

    /**
     * Метод получения задачи по id
     * @param id персональный идентификатор задачи
     * @return
     */
    public Optional<Task> getTaskById(Long id){
        return repository.findById(id);
    }

    /**
     * Метод создания новой задачи
     * @param task новая задача
     * @return
     */
    public Task createTask(Task task){
        task.setTaskStatus(TaskStatus.NOT_STARTED);
        task.setDateOfCreation(LocalDateTime.now());
//        repository.save(task);
        return repository.save(task);
    }

    public List<Task> getTasksByStatus(TaskStatus taskStatus){
        return repository.findByStatus(taskStatus);
    }

    /**
     * Метод удаления задачи по id
     * @param id персональный идентификатор задачи
     */
    public void deleteTaskBuId(Long id){
        repository.deleteById(id);
    }
    /**
     * Метод обновления статуса задачи
     *
     * @return
     */
    public Task updateTaskByStatus(Long id, Task task){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task updateTask = optionalTask.get();
//            updateTask.setId(task.getId());
//            updateTask.setDescription(task.getDescription());
            updateTask.setTaskStatus(task.getTaskStatus());
//            updateTask.setDateOfCreation(LocalDateTime.now());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }



}
