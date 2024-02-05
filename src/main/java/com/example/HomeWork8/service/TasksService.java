package com.example.HomeWork8.service;

import com.example.HomeWork8.aspects.TrackUserAction;
import com.example.HomeWork8.model.Task;
import com.example.HomeWork8.model.TaskStatus;
import com.example.HomeWork8.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TasksService {

    private Logger logger = Logger.getLogger(TasksService.class.getName());

    private final TaskRepository taskRepository;

    /**
     * Получить список всех заметок
     * @return список заметок
     */
    @TrackUserAction
    public ResponseEntity<List<Task>> findAll() {
        List<Task> allTasks = taskRepository.findAll();
                System.out.println("---> TasksService allTasks <---" + allTasks);
        return new ResponseEntity<>(taskRepository.findAll(), HttpStatus.CREATED);

    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @TrackUserAction
    public ResponseEntity<Task> addTask(Task task) {
        task.setDateOfCreation(LocalDateTime.now());
        task.setTaskStatus(TaskStatus.NOT_STARTED);
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.CREATED);
    }

    @TrackUserAction
    public Optional<Task> findByTaskStatus(TaskStatus status) {
        return taskRepository.findByTaskStatus(status);
    }

    @TrackUserAction
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @TrackUserAction
    public ResponseEntity<Task> updateById(Long id, Task task) {
        Task taskUpdateStatus = taskRepository.findById(id).orElse(null);
        if(taskUpdateStatus != null){
            taskUpdateStatus.setTaskStatus(task.getTaskStatus());
            return new ResponseEntity<>(taskRepository.save(taskUpdateStatus), HttpStatus.CREATED);
        } else {
            return null;
        }
    }

    @TrackUserAction
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
