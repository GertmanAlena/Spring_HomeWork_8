package com.example.HomeWork8.service;

import com.example.HomeWork8.aspects.TrackUserAction;
import com.example.HomeWork8.model.Task;
import com.example.HomeWork8.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
public class TasksService {

    private Logger logger = Logger.getLogger(TasksService.class.getName());
    private final TaskRepository taskRepository;

    @TrackUserAction
    public String publishComment(Long id) {
        System.out.println("Удалили заметнку с id: " + id);
        return "SUCCESS";
    }
    /**
     * Получить список всех заметок
     * @return список заметок
     */

    public ResponseEntity<List<Task>> findAll() {
        return new ResponseEntity<>(taskRepository.findAll(), HttpStatus.OK);

    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

}
