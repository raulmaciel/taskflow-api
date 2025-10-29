package com.devraul.taskflow.model;

import com.devraul.taskflow.dto.TaskDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
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

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "dueTime")
    private LocalDate dueTime;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;


    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    public Task(TaskDTO taskDTO) {
        this.title = taskDTO.getTitle();
        this.description = taskDTO.getDescription();
        this.priority = (taskDTO.getPriority() != null) ? taskDTO.getPriority() : Priority.LOW;
        this.status = (taskDTO.getStatus() != null) ? taskDTO.getStatus() : Status.TODO;
        this.dueTime = taskDTO.getDueTime();
    }

//    public Task(TaskDTO taskDTO){
////        BeanUtils.copyProperties(taskDTO, this);
//
//    }

}
