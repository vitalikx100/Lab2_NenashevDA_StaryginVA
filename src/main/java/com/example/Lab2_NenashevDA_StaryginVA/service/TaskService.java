package com.example.Lab2_NenashevDA_StaryginVA.service;

import com.example.Lab2_NenashevDA_StaryginVA.model.Task;
import com.example.Lab2_NenashevDA_StaryginVA.model.User;
import com.example.Lab2_NenashevDA_StaryginVA.repository.TaskRepository;
import com.example.Lab2_NenashevDA_StaryginVA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public void createTask(Task task) {
        if (task.getUser() == null || task.getUser().getId() == null) {
            throw new RuntimeException("User must be specified for the task");
        }

        User user = userRepository.findById(task.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + task.getUser().getId()));

        task.setUser(user);
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        if (!taskRepository.existsById(task.getId())) {
            throw new RuntimeException("Task with ID " + task.getId() + " not found");
        }

        if (task.getUser() != null && task.getUser().getId() != null) {
            User user = userRepository.findById(task.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + task.getUser().getId()));
            task.setUser(user);
        }

        taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }

    public long getCompletedTasksCount() {
        return taskRepository.countByCompletedTrue();
    }
}