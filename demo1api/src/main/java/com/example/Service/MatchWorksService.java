package com.example.Service;

import com.example.Dao.student_infoMapper;
import com.example.Dao.student_matchMapper;
import com.example.Dao.student_work_managementMapper;
import com.example.Po.student_match;
import com.example.Po.student_work_management;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchWorksService {

    @Autowired
    student_infoMapper student_infoMapper;

    @Autowired
    student_work_managementMapper student_work_managementMapper;

    @Autowired
    student_matchMapper student_matchMapper;

    public List<student_match> selectmatch(int matchid){
        return student_matchMapper.selectmatch(matchid);
    }

    public String stuname(int studentid){
        return student_infoMapper.stuname(studentid);
    }

    public student_work_management stuworks(int worksid,int studentid){
        return student_work_managementMapper.stuworks(worksid,studentid);
    }

    public int stuscore(int matchid,int worksid,int studentid){
        return student_matchMapper.selectscore(matchid,worksid,studentid);
    }

    public int deleteStuworks(int matchid,int studentid){
        return student_matchMapper.deleteStuworks(matchid,studentid);
    }

    public int updateStuworks(int matchid,int studentid,int score){
        return student_matchMapper.updateStuworks(matchid,studentid,score);
    }
}
