package com.example.Lab2_NenashevDA_StaryginVA.controller;

import com.example.Lab2_NenashevDA_StaryginVA.model.Task;
import com.example.Lab2_NenashevDA_StaryginVA.service.TaskService;
import com.example.Lab2_NenashevDA_StaryginVA.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        long completedCount = taskService.getCompletedTasksCount();

        model.addAttribute("tasks", tasks);
        model.addAttribute("completedCount", completedCount);
        return "task/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("users", userService.getAllUsers());
        return "task/create";
    }

    @PostMapping("/create")
    public String createTask(@Valid @ModelAttribute Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.getAllUsers());
            return "task/create";
        }
        try {
            taskService.createTask(task);
            return "redirect:/tasks";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("users", userService.getAllUsers());
            return "task/create";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            model.addAttribute("users", userService.getAllUsers());
            return "task/edit";
        } else {
            return "redirect:/tasks";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable Integer id, @Valid @ModelAttribute Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.getAllUsers());
            return "task/edit";
        }
        try {
            task.setId(id);
            taskService.updateTask(task);
            return "redirect:/tasks";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("users", userService.getAllUsers());
            return "task/edit";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}