package com.example.Dao;

import com.example.Po.match_news;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface match_newsMapper {
    List<match_news> select();

    int addMn(int matchid,String newstitle,String matchnews);

    int deleteMn(int newsid);

    int updateMn(int newsid,int matchid,String newstitle,String matchnews);
}