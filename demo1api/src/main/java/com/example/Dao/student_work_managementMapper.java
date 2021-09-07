package com.example.Dao;

import com.example.Po.student_work_management;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface student_work_managementMapper {
    student_work_management stuworks(int worksid, int studentid);

    List<student_work_management> stuallworks(int studentid);

    student_work_management stualloneworks(int worksid);
}