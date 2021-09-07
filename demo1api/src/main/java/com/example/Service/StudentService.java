package com.example.Service;

import com.example.Po.student_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    com.example.Dao.student_infoMapper student_infoMapper;

    public student_info login(int Telephone,String Password){

        return student_infoMapper.login(Telephone,Password);
    }
    public student_info selecttelephone(int Telephone){

        return student_infoMapper.selecttelephone(Telephone);
    }

    public student_info stuinfo(int studentid){
        return student_infoMapper.stuinfo(studentid);
    }

    public int register(int Telephone,String Password){

        return student_infoMapper.register(Telephone,Password);
    }
    public List<student_info> selectAll(){
        return student_infoMapper.selectAll();
    }

    public int stuid(int telephone){
        return student_infoMapper.stuid(telephone);
    }

    public int addstu(student_info student_info){
        return student_infoMapper.addStu(student_info);
    }

    public int deletestu(int studentid){

        return student_infoMapper.deleteStu(studentid);
    }

    public int updatestu(student_info student_info){
        return student_infoMapper.updateStu(student_info);
    }
}
