package com.StudentManagementSystem.khaled.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @SequenceGenerator(
            name = "studentId",
            sequenceName = "studentId",
            initialValue = 1000,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "studentId"
    )
    private Long id;
    private String first_name;
    private String last_name;
    private LocalDate joinDate=LocalDate.now();
    @ManyToOne
    @JoinColumn
    private Group group;

    public Student() {
    }

    public Student(Long id, String first_name, String last_name, Group group) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_Name='" + first_name + '\'' +
                ", last_Name='" + last_name + '\'' +
                ", group=" + group +
                '}';
    }
}
