package com.StudentManagementSystem.khaled.service;

import com.StudentManagementSystem.khaled.entity.Mark;
import com.StudentManagementSystem.khaled.repository.MarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {
    @Autowired
    private MarkRepo markRepo;
    public List<Mark> getAllStudentMarks(Long StudentId){
        return markRepo.findByStudentId(StudentId).get();
    }
    public Mark addMark(Mark mark) {
        return markRepo.save(mark);
    }
    public List<Mark> getAllMarks() {
        return markRepo.findAll();
    }
    public ResponseEntity getMarkById (Long id){
        Optional<Mark> mark =markRepo.findById(id);
        if (mark.isPresent()){
            return new ResponseEntity(mark , HttpStatus.OK);
        }
        return new ResponseEntity("Not Found " , HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity updateMark (Long id , Mark mark){
        if (markRepo.findById(id).isPresent()){
            mark.setId(id);
            return new ResponseEntity(markRepo.save(mark) , HttpStatus.OK);
        }
        return new ResponseEntity("id doesn't exist" , HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity delete(Long id) {
        if (markRepo.findById(id).isPresent()){
            markRepo.deleteById(id);
            return new ResponseEntity("Mark deleted successfully" , HttpStatus.OK);
        }
        return new ResponseEntity("id doesn't exist may be it's already deleted" , HttpStatus.BAD_REQUEST);
    }

}
