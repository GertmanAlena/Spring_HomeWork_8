package com.example.HomeWork5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    /**
     * Персональный идентификационный номер задачи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Oписание задачи */
    @Column(nullable = false)
    private String description;

    /**
     * Cтатус задачи
     */
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    /**
     * Дата создания задачи
     */
    private LocalDateTime dateOfCreation;

}
