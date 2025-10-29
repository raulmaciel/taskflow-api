package com.devraul.taskflow.controller;

import com.devraul.taskflow.dto.TaskDTO;
import com.devraul.taskflow.model.Priority;
import com.devraul.taskflow.model.Status;
import com.devraul.taskflow.model.Task;
import com.devraul.taskflow.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController()
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> listarTodos(){
        return taskService.listarTodos();
    }

    @PostMapping
    public void inserirTask(@RequestBody TaskDTO taskDTO){
        taskService.inserir(taskDTO);
    }

    @PutMapping
    public TaskDTO alterarTask(@RequestBody TaskDTO taskDTO){
        return taskService.alterar(taskDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        taskService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/priority/{priority}")
    public List<TaskDTO> buscarPorPrioridade(@PathVariable Priority priority){
        return taskService.buscarPorPrioridade(priority);
    }

    @GetMapping("/status/{status}")
    public List<TaskDTO> buscarPorStatus(@PathVariable Status status){
        return taskService.buscarPorStatus(status);
    }

    @GetMapping("/title/{title}")
    public List<TaskDTO> buscarPorTitulo(@PathVariable String title){
        return taskService.buscarPorTitulo(title);
    }

    @GetMapping("/due-before/{date}")
    public List<TaskDTO> buscarPorDueTime(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDate date){
        return taskService.buscarPorDueTime(date);
    }

    @GetMapping("/filter")
    public List<TaskDTO> buscarPorPrioridadeEStatus(@RequestParam(required = false) Priority priority, @RequestParam(required = false) Status status){
        return taskService.buscarPorPrioridadeEStatus(priority, status);
    }
}
