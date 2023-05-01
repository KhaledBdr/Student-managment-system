package com.StudentManagementSystem.khaled.controller;

import com.StudentManagementSystem.khaled.entity.SubjectTeach;
import com.StudentManagementSystem.khaled.service.SubjectTeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject-teach")
public class SubjectTeachController {
    @Autowired
    private SubjectTeachService teachService;

    @GetMapping("/all")
    public List<SubjectTeach> viewAll(){
        return teachService.findAll();
    }
    @GetMapping("/id/{id}")
    public ResponseEntity viewById(@PathVariable("id") Long id) {
        return teachService.findById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id , @RequestBody SubjectTeach subjectTeach){
        return teachService.update(id,subjectTeach);
    }
    @PostMapping("/add")
    public SubjectTeach saveOne(@RequestBody SubjectTeach subjectTeach) {
        return teachService.addOne(subjectTeach);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        teachService.deleteById(id);
    }
}
