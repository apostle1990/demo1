package com.example.Service;

import com.example.Dao.teacher_infoMapper;
import com.example.Dao.teacher_matchMapper;
import com.example.Po.teacher_info;
import com.example.Po.teacher_match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherMatchService {

    @Autowired
    teacher_matchMapper teacher_matchMapper;

    @Autowired
    teacher_infoMapper teacher_infoMapper;

    public List<teacher_match> selectteacher(int matchid){

        return teacher_matchMapper.selectteacher(matchid);
    }

    public int addmt(int matchid,int teacherid){

        return teacher_matchMapper.addmt(matchid,teacherid);
    }

    public int deletemt(int matchid,int teacherid){

        return teacher_matchMapper.deletemt(matchid,teacherid);
    }

    public teacher_info selectTeacher(int teacherid){

        return teacher_infoMapper.selectTeacher(teacherid);
    }

}
