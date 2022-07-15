package com.example.apirestbiblioteca.entity;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private ZonedDateTime startingDate;
    @Column(nullable = false)
    private ZonedDateTime endingDate;
    @ManyToOne
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(ZonedDateTime startingDate) {
        this.startingDate = startingDate;
    }

    public ZonedDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(ZonedDateTime endingDate) {
        this.endingDate = endingDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
