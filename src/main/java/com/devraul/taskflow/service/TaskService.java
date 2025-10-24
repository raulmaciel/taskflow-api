package com.devraul.taskflow.service;

import com.devraul.taskflow.dto.TaskDTO;
import com.devraul.taskflow.model.Priority;
import com.devraul.taskflow.model.Status;
import com.devraul.taskflow.model.Task;
import com.devraul.taskflow.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> listarTodos(){
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskDTO::new).toList();         // Aqui eu percorro a lista e converto para TaskDTO
    }

    @Transactional
    public void inserir(TaskDTO taskDTO){
        Task task = new Task(taskDTO);
        taskRepository.save(task);
    }

    @Transactional
    public TaskDTO alterar(TaskDTO taskDTO){
        Task task = new Task(taskDTO);
        return new TaskDTO(taskRepository.save(task));
    }

    @Transactional
    public void excluir(Long id){
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
    }

    public TaskDTO buscarPorId(Long id){
        Task task = taskRepository.findById(id).get();
        return new TaskDTO(task);
    }

    public List<TaskDTO> buscarPorPrioridade(Priority priority){
        List<Task> tasks = taskRepository.findByPriority(priority);
        return tasks.stream().map(TaskDTO::new).toList();
    }

    public List<TaskDTO> buscarPorStatus(Status status){
        List<Task> tasks = taskRepository.findByStatus(status);
        return tasks.stream().map(TaskDTO::new).toList();
    }

    public List<TaskDTO> buscarPorTitulo(String title){
        List<Task> tasks = taskRepository.findByTitleContainingIgnoreCase(title);
        return tasks.stream().map(TaskDTO::new).toList();
    }

    public List<TaskDTO> buscarPorDueTime(LocalDate localDate){
        List<Task> tasks = taskRepository.findByDueTimeBefore(localDate);
        return tasks.stream().map(TaskDTO::new).toList();
    }

    public List<TaskDTO> buscarPorPrioridadeEStatus(Priority priority, Status status){
        List<Task> tasks = taskRepository.findByPriorityAndStatus(priority, status);
        return tasks.stream().map(TaskDTO::new).toList();
    }



}
