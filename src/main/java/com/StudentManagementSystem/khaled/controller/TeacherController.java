package com.StudentManagementSystem.khaled.controller;

import com.StudentManagementSystem.khaled.entity.Group;
import com.StudentManagementSystem.khaled.entity.Teacher;
import com.StudentManagementSystem.khaled.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/all")
    public List<Teacher> viewAllTeachers() {
        return teacherService.findAllTeachers();
    }
    @GetMapping("/id/{id}")
    public Teacher viewById(@PathVariable("id") Long id) {
        return teacherService.findTeacherById(id);
    }
    @PostMapping("/add")
    public Teacher addTeacher(@RequestBody Teacher Teacher) {
        return teacherService.addTeacher(Teacher);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") Long id , @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable("id") Long id){
        return teacherService.deleteTeacher(id);
    }

}
