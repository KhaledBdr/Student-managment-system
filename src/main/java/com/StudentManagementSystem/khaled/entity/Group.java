package com.StudentManagementSystem.khaled.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Groups_sec")
public class Group {
    @Id
    @SequenceGenerator(
            name = "groupId",
            sequenceName = "groupId",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "groupId"
    )
    private Long id;
    private String name;

    public Group() {
    }
    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
