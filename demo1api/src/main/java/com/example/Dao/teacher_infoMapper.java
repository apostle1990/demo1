package com.example.Dao;

import com.example.Po.teacher_info;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface teacher_infoMapper {
    teacher_info login(int telephone, String password);

    List<teacher_info> selectAll();

    teacher_info selectTeacher(int teacherid);

    int selectteacherid(int telephone);

    int addteacher(int telephone,String teachername,String password,String email, int qq);

    int deleteteacher(int teacherid);

    int updateteacher(int teacherid,String teachername,String password,String email, int qq);

    teacher_info selecttelephone(int telephone);
}