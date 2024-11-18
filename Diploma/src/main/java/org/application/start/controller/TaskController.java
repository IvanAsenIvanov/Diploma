//package org.application.start.controller;
//
//
//import org.application.start.model.Task;
//import org.application.start.operation.TaskRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/tasks")
//public class TaskController {
//
//    private TaskRepository taskManager;
//
//    public TaskController(TaskRepository taskManager) {
//        this.taskManager = taskManager;
//    }
//
//
//    @PostMapping
//    public void addTask(@PathVariable String path) {
//        taskManager.createTask(path);
//    }
//
//    @PutMapping("/{id}")
//    public void updateTask(@PathVariable String id, @RequestBody Task task) throws IOException {
//        taskManager.updateTask(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteTask(@PathVariable String id) throws IOException {
//        taskManager.deleteTask(id);
//    }
//}
