package com.devraul.taskflow.model;

import com.devraul.taskflow.dto.TaskDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Getter @Setter @RequiredArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 500)
    private String description;


    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private Priority priority;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "dueTime")
    private LocalDate dueTime;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;


    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    public Task(TaskDTO taskDTO){
        BeanUtils.copyProperties(taskDTO, this);
    }

}
