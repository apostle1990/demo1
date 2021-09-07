package com.example.Service;

import com.example.Dao.match_infoMapper;
import com.example.Dao.teacher_matchMapper;
import com.example.Dao.teacher_scoreMapper;
import com.example.Po.match_info;
import com.example.Po.teacher_match;
import com.example.Po.teacher_score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherScoreService {

    @Autowired
    teacher_scoreMapper teacher_scoreMapper;

    @Autowired
    teacher_matchMapper teacher_matchMapper;

    @Autowired
    match_infoMapper match_infoMapper;

    public List<match_info> selectmatch(int teacherid){
        List<teacher_match> teacherMatches=teacher_matchMapper.selectmatch(teacherid);
        match_info match_info = new match_info();
        List<match_info> match_infos = new ArrayList<>();
        for (int i=0; i<teacherMatches.size();i++){
            match_info = match_infoMapper.selectmatch(teacherMatches.get(i).getMatchid());
            match_infos.add(match_info);
        }

        return match_infos;
    }

    public int  setscore(teacher_score teacher_score){
        if(teacher_scoreMapper.selectscore(teacher_score.getTeacherid(),teacher_score.getMatchid(),teacher_score.getWorksid())!=null){
            return teacher_scoreMapper.updatescore(teacher_score);
        }else{
            return teacher_scoreMapper.insertscore(teacher_score);
        }
    }
}
