package com.StudentManagementSystem.khaled.controller;

import com.StudentManagementSystem.khaled.entity.Subject;
import com.StudentManagementSystem.khaled.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/all")
    public List<Subject> getAll() {
        return subjectService.findAll();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Subject> getById(@PathVariable("id") Long id) {
        return subjectService.findById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Subject subject) {
        return subjectService.addOne(subject);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id , @RequestBody Subject subject) {
        return subjectService.update(id , subject);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        return subjectService.delete(id);
    }
}
