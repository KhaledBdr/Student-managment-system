package com.StudentManagementSystem.khaled.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Mark {
    @Id
    @SequenceGenerator(
            name = "markId",
            sequenceName = "markId",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "markId"
    )
    private Long id;
    private Timestamp date= Timestamp.valueOf(LocalDateTime.now());
    @NonNull
    private Integer mark;
    @NonNull
    @ManyToOne
    @JoinColumn
    private Student student;
    @NonNull
    @ManyToOne
    @JoinColumn
    private Subject subject;

    public Mark() {
    }

    public Mark(Long id, Timestamp date, Integer mark, Student student, Subject subject) {
        this.id = id;
        this.date = date;
        this.mark = mark;
        this.student = student;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", date=" + date +
                ", mark=" + mark +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
