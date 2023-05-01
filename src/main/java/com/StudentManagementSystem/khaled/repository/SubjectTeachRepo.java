package com.StudentManagementSystem.khaled.repository;

import com.StudentManagementSystem.khaled.entity.SubjectTeach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTeachRepo extends JpaRepository<SubjectTeach, Long> {
}
