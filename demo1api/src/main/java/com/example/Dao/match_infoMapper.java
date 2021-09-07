package com.example.Dao;

import com.example.Po.match_info;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface match_infoMapper {
    List<match_info> SelectAll();

    match_info selectmatch(int matchid);

    int addmatch(String matchname,String matchcontext,String matchstate);

    int deletematch(int matchid);

    int updatematch(int matchid,String matchname,String matchcontext,String matchstate);
}