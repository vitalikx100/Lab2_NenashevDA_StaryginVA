package com.example.Lab2_NenashevDA_StaryginVA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "Created date is mandatory")
    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @NotNull(message = "Completed status is mandatory")
    @Column(name = "completed", nullable = false)
    private Boolean completed = false;

    public Task() {
        this.createdDate = LocalDate.now();
    }

    public Task(String title, User user, LocalDate createdDate, Boolean completed) {
        this.title = title;
        this.user = user;
        this.createdDate = createdDate != null ? createdDate : LocalDate.now();
        this.completed = completed != null ? completed : false;
    }

    public Integer getUserId() {
        return user != null ? user.getId() : null;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + (user != null ? user.getId() : null) +
                ", createdDate=" + createdDate +
                ", completed=" + completed +
                '}';
    }
}