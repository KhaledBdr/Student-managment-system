package com.StudentManagementSystem.khaled.repository;

import com.StudentManagementSystem.khaled.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student , Long> {
}
