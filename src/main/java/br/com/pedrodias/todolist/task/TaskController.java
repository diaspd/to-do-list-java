package br.com.pedrodias.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

  @Autowired
  private ITaskRepository taskRepository;

  @PostMapping("/")
  public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
    System.out.println("Chegou no controller" + request.getAttribute("idUser"));
    var task = this.taskRepository.save(taskModel);
    return task;
  }
  
}
