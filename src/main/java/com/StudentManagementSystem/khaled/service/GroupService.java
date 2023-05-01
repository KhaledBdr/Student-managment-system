package com.StudentManagementSystem.khaled.service;

import com.StudentManagementSystem.khaled.entity.Group;
import com.StudentManagementSystem.khaled.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;

    public Group addGroup(Group group) {
        return groupRepo.save(group);
    }
    public List<Group> findAllGroups() {
        return groupRepo.findAll();
    }
    public Group findGroupById(Long id) {
        return groupRepo.findById(id).orElse(null);
    }
    public String editGroup(Group group) {
        if (! groupRepo.findById(group.getId()).isPresent()) return "Group Not Exists";
        groupRepo.save(group);
        return "Group Updated Successfully";
    }
    public int deleteGroup (Long id) {
        if (groupRepo.findById(id).isPresent()){
            groupRepo.deleteById(id);
            return 200;
        }
        return 400;
    }
}
