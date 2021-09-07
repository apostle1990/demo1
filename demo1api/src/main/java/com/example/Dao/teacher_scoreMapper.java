package com.example.Dao;

import com.example.Po.teacher_score;
import org.springframework.stereotype.Repository;

@Repository
public interface teacher_scoreMapper {
    teacher_score selectscore(int teacherid,int matchid,int worksid);

    int insertscore(teacher_score record);

    int updatescore(teacher_score record);
}