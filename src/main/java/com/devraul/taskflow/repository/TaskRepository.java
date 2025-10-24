package com.devraul.taskflow.repository;

import com.devraul.taskflow.model.Priority;
import com.devraul.taskflow.model.Status;
import com.devraul.taskflow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByPriority(Priority priority);
    List<Task> findByStatus(Status status);
    List<Task> findByTitleContainingIgnoreCase(String title);
    List<Task> findByDueTimeBefore(LocalDate date);
    List<Task> findByPriorityAndStatus(Priority priority, Status status);
}
