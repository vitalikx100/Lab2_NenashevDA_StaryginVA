package com.example.Lab2_NenashevDA_StaryginVA.repository;

import com.example.Lab2_NenashevDA_StaryginVA.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    long countByCompletedTrue();
}