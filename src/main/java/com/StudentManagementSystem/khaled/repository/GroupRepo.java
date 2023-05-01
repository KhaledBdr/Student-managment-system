package com.StudentManagementSystem.khaled.repository;

import com.StudentManagementSystem.khaled.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group , Long> {
}
