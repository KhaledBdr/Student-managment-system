package com.StudentManagementSystem.khaled.repository;

import com.StudentManagementSystem.khaled.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher , Long> {
}
