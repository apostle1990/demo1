package com.example.Dao;

import com.example.Po.teacher_match;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface teacher_matchMapper {
    List<teacher_match> selectteacher(int matchid);

    List<teacher_match> selectmatch(int teacherid);

    int addmt(int matchid,int teacherid);

    int deletemt(int matchid,int teacherid);
}