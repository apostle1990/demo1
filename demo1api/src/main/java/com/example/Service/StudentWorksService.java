package com.example.Service;

import com.example.Dao.student_work_managementMapper;
import com.example.Po.student_work_management;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentWorksService {

    @Autowired
    com.example.Dao.student_work_managementMapper student_work_managementMapper;

    public List<student_work_management> stuallworks(int studentid){
        return student_work_managementMapper.stuallworks(studentid);
    }
}
