package com.devraul.taskflow.dto;

import com.devraul.taskflow.model.Priority;
import com.devraul.taskflow.model.Status;
import com.devraul.taskflow.model.Task;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class TaskDTO {
    private Long id;

    @NotBlank(message = "O título da tarefa tem que ser nomeado")
    private String title;

    private String description;

    @NotNull(message = "Você deve designar uma prioridade para esta tarefa")
    private Priority priority;

    @NotNull(message = "Você deve atribuir um status")
    private Status status;

    @FutureOrPresent(message = "A data limite deve ser no futuro ou hoje")
    private LocalDate dueTime;


    private LocalDateTime createdAt;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.priority = task.getPriority();
        this.status = task.getStatus();
        this.dueTime = task.getDueTime();
        this.createdAt = task.getCreatedAt();
    }

//    public TaskDTO(Task task) {
//            BeanUtils.copyProperties(task, this);
//        }

    public TaskDTO() {
        }


    }
