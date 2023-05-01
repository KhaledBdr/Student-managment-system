package com.StudentManagementSystem.khaled.service;

import com.StudentManagementSystem.khaled.entity.Subject;
import com.StudentManagementSystem.khaled.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;

    public List<Subject> findAll() {
        return subjectRepo.findAll(Sort.by("title"));
    }

    public ResponseEntity<Subject> findById(Long id) {
        Optional<Subject> subject = subjectRepo.findById(id);
        if (subject.isPresent()){
            return new ResponseEntity(subject.orElseThrow() , HttpStatus.OK);
        }
        return new ResponseEntity(null , HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addOne(Subject subject) {
        Optional <Subject> s = subjectRepo.findByTitle(subject.getTitle());
        if(s.isPresent()){
            return new ResponseEntity("already exists with id "+ s.get().getId() , HttpStatus.BAD_REQUEST);
        }
        Subject saved = subjectRepo.save(subject);
        return new ResponseEntity("Subject Saved Successfully \n" + saved.toString() , HttpStatus.OK);
    }
    public ResponseEntity<String> delete(Long id) {
        Optional <Subject> s = subjectRepo.findById(id);
        if(s.isPresent()){
            subjectRepo.deleteById(id);
            return new ResponseEntity("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity("Subject not found" , HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> update(Long id , Subject subject) {
        Optional <Subject> s = subjectRepo.findById(id);
        if(s.isPresent()){
            subject.setId(id);
            subjectRepo.save(subject);
            return new ResponseEntity("Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity("Subject not found to edit" , HttpStatus.BAD_REQUEST);
    }
}
