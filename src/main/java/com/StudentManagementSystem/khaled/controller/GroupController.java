package com.StudentManagementSystem.khaled.controller;

import com.StudentManagementSystem.khaled.entity.Group;
import com.StudentManagementSystem.khaled.service.GroupService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping("/all")
    public List<Group> viewAllGroups() {
        return groupService.findAllGroups();
    }
    @GetMapping("/id/{id}")
    public Group viewById(@PathVariable("id") Long id) {
        return groupService.findGroupById(id);
    }
    @PostMapping("/add")
    public Group addGroup(@RequestBody Group group) {
        return groupService.addGroup(group);
    }
    @PutMapping("/update/{id}")
    public String updateById(@PathVariable("id") Long id , @RequestBody Group group) {
        group.setId(id);
        return groupService.editGroup(group);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable("id") Long id){
        int result = groupService.deleteGroup(id);
        if (result == 200) return new ResponseEntity<>("Group deleted Successfully" , HttpStatus.OK);
        return new ResponseEntity<>("Group doesn't exists " , HttpStatus.BAD_REQUEST);
    }

}
