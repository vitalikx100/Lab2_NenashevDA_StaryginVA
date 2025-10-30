package com.example.Lab2_NenashevDA_StaryginVA.repository;

import com.example.Lab2_NenashevDA_StaryginVA.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUser_Id(Integer userId);

    List<Task> findByUser_Email(String email);

    long countByUser_Id(Integer userId);

    List<Task> findByCompleted(Boolean completed);
}