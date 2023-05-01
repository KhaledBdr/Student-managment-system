package com.StudentManagementSystem.khaled.service;

import com.StudentManagementSystem.khaled.entity.SubjectTeach;
import com.StudentManagementSystem.khaled.repository.SubjectTeachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectTeachService {
    @Autowired
    private SubjectTeachRepo subRepo;
    public List<SubjectTeach> findAll() {
        return subRepo.findAll(Sort.by("id"));
    }

    public ResponseEntity findById(Long id) {
        Optional<SubjectTeach> subjectTeach = subRepo.findById(id);
        if (subjectTeach.isPresent()){
            return new ResponseEntity(subjectTeach.get(),HttpStatus.OK);
        }
        return new ResponseEntity( "Id not found",HttpStatus.BAD_REQUEST );
    }

    public ResponseEntity update(Long id , SubjectTeach subjectTeach) {
        Optional<SubjectTeach> exists = subRepo.findById(id);
        if (exists.isPresent()){
            subjectTeach.setId(id);
            return new ResponseEntity(subRepo.save(subjectTeach),HttpStatus.OK);
        }
        return new ResponseEntity( "Id not found to Update",HttpStatus.BAD_REQUEST );
    }
    public SubjectTeach addOne(SubjectTeach subjectTeach) {
        return subRepo.save(subjectTeach);
    }

    public void deleteById(Long id) {
        subRepo.deleteById(id);
    }
}
