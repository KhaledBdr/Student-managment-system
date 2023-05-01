package com.StudentManagementSystem.khaled.service;

import com.StudentManagementSystem.khaled.entity.Student;
import com.StudentManagementSystem.khaled.exception.NotFoundException;
import com.StudentManagementSystem.khaled.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public List<Student> findAll(){
        return studentRepo.findAll();
    }
    public Student findById(Long id) {
        return studentRepo.findById(id).orElseThrow(()-> new NotFoundException());
    }
    public Student add(Student student) {
        return studentRepo.save(student);
    }

    public ResponseEntity<Student> update(Long id , Student student) {
        Optional <Student> studentOptional =studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            student.setId(id);
            return new ResponseEntity(studentRepo.save(student) , HttpStatus.OK);
        }
        throw new NotFoundException();
    }

    public ResponseEntity<String> delete(Long id) {
        if (studentRepo.findById(id).isPresent()){
            return new ResponseEntity("Deleted Successfully" , HttpStatus.OK);
        }
        return  new ResponseEntity("id not already exist" , HttpStatus.BAD_REQUEST);
    }
}
