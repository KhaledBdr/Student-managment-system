package com.StudentManagementSystem.khaled.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Entity
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacherId",
            sequenceName = "teacherId",
            initialValue = 100,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacherId"
    )
    private Long id;

    private String first_name;
    private String last_name;
    private LocalDate hire_date= LocalDate.now();
    private double salary;

    public Teacher() {
    }

    public Teacher(Long id, String first_name, String last_name, LocalDate hire_date, double salary) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.hire_date = hire_date;
        this.salary = salary;
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

    public LocalDate getHire_date() {
        return hire_date;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = LocalDate.now();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", hire_date=" + hire_date +
                ", salary=" + salary +
                '}';
    }

}
