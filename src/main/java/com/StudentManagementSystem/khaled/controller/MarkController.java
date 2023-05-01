package com.StudentManagementSystem.khaled.controller;

import com.StudentManagementSystem.khaled.entity.Mark;
import com.StudentManagementSystem.khaled.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {
    @Autowired
    private MarkService markService;

    @GetMapping("/all")
    public List<Mark> viewAll() {
        return markService.getAllMarks();
    }
    @GetMapping("/student/{studentId}")
    public List<Mark> viewStudentMarks(@PathVariable("studentId") Long studentId) {
        return markService.getAllStudentMarks(studentId);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity viewMark(@PathVariable("id") Long id) {
        return markService.getMarkById(id);
    }
    @PostMapping("/add")
    public Mark addOne(@RequestBody Mark mark) {
        return markService.addMark(mark);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMark (@PathVariable("id") Long id , @RequestBody Mark mark) {
        return markService.updateMark(id,mark);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOne(@PathVariable("id") Long id) {
        return markService.delete(id);
    }
}
