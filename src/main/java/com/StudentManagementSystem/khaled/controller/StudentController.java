package com.StudentManagementSystem.khaled.controller;

import com.StudentManagementSystem.khaled.entity.Student;
import com.StudentManagementSystem.khaled.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.add(student);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Long id , @RequestBody Student student) {
        return studentService.update(id , student);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return studentService.delete(id);
    }
}
