package com.example.Service;

import com.example.Dao.student_infoMapper;
import com.example.Po.teacher_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    com.example.Dao.teacher_infoMapper teacher_infoMapper;

    public teacher_info login(int Telephone, String Password){

        return teacher_infoMapper.login(Telephone,Password);
    }
    public List<teacher_info> selectAll(){

        return teacher_infoMapper.selectAll();
    }
    public teacher_info selecttelephone(int Telephone){

        return teacher_infoMapper.selecttelephone(Telephone);
    }

    public int selectteacherid(int telephone){
        return teacher_infoMapper.selectteacherid(telephone);
    }

    public int addteacher(int telephone,String teachername,String password,String email, int qq){
        return teacher_infoMapper.addteacher(telephone,teachername,password,email,qq);
    }

    public int deleteteacher(int teadentid){

        return teacher_infoMapper.deleteteacher(teadentid);
    }

    public int updateteacher(int teadentid,String teachername,String password,String email, int qq) {
        return teacher_infoMapper.updateteacher(teadentid, teachername, password, email, qq);
    }
}
