package com.example.Dao;

import com.example.Po.student_match;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface student_matchMapper {
    List<student_match> selectmatch(int matchid);

    List<student_match> stumatch(int studentid);

    int selectscore(int matchid,int worksid,int studentid);

    int deleteStuworks(int matchid,int studentid);

    int updateStuworks(int matchid,int studentid,int score);
}