package com.StudentManagementSystem.khaled.repository;

import com.StudentManagementSystem.khaled.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepo extends JpaRepository<Subject , Long> {
    public Optional<Subject> findByTitle(String title);
}
