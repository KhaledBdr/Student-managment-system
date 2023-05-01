package com.StudentManagementSystem.khaled.entity;

import jakarta.persistence.*;

@Entity
public class SubjectTeach {
    @Id
    @SequenceGenerator(
            name = "teachId",
            sequenceName = "teachId",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teachId"
    )
    private Long id;
    @ManyToOne
    @JoinColumn
    private Teacher teacher;
    @ManyToOne
    @JoinColumn
    private Group group;
    @ManyToOne
    @JoinColumn
    private Subject subject;

    public SubjectTeach() {
    }
    public SubjectTeach(Long id, Teacher teacher, Group group, Subject subject) {
        this.id = id;
        this.teacher = teacher;
        this.group = group;
        this.subject = subject;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "SubjectTeach{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", group=" + group +
                ", subject=" + subject +
                '}';
    }
}
