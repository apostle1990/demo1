package com.example.Dao;

import com.example.Po.student_info;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface student_infoMapper {

    student_info login(int telephone,String password);

    student_info selecttelephone(int telephone);

    student_info stuinfo(int studentid);

    int register(int telephone,String password);

    List<student_info> selectAll();

    int stuid(int telephone);

    int addStu(student_info record);

    int deleteStu(int studentid);

    int updateStu(student_info record);

    String stuname(int studentid);
}