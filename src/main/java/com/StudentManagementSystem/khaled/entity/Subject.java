package com.StudentManagementSystem.khaled.entity;

import jakarta.persistence.*;
import org.aspectj.lang.annotation.RequiredTypes;

@Entity
public class Subject {
    @Id
    @SequenceGenerator(
            name = "subjectId",
            sequenceName = "subjectId",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subjectId"
    )
    private Long id;

    private String title;
    public Subject(){

    }

    public Subject(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
