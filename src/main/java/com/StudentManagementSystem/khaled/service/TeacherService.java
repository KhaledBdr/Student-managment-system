package com.StudentManagementSystem.khaled.service;

import com.StudentManagementSystem.khaled.entity.Teacher;
import com.StudentManagementSystem.khaled.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;

    public List<Teacher> findAllTeachers() {
        return teacherRepo.findAll(Sort.by("id"));
    }
    public Teacher findTeacherById(Long id) {
        return teacherRepo.findById(id).get();
    }
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }
    public ResponseEntity<String> updateTeacher(Long id , Teacher teacher){

        if(teacherRepo.findById(id).isPresent()){
            teacher.setId(id);
            teacherRepo.save(teacher);
            return new ResponseEntity("Teacher update successfully exist ",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Teacher Doesn't exist", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> deleteTeacher(Long id) {
        if (teacherRepo.findById(id).isPresent()){
            teacherRepo.deleteById(id);
            return new ResponseEntity<>("Teacher deleted Successfully" , HttpStatus.OK);
        }
        return new ResponseEntity<>("Teacher doesn't exists " , HttpStatus.BAD_REQUEST);
    }
}
