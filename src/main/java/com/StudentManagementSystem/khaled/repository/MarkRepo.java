package com.StudentManagementSystem.khaled.repository;

import com.StudentManagementSystem.khaled.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarkRepo extends JpaRepository <Mark , Long> {

    public Optional<List<Mark>> findByStudentId(Long studentId);
}
