package com.example.Service;

import com.example.Dao.match_infoMapper;
import com.example.Po.match_news;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchNewsService {

    @Autowired
    com.example.Dao.match_newsMapper match_newsMapper;

    public List<match_news> selectAll(){
        return match_newsMapper.select();
    }

    public int addMn(int matchid,String newstitle,String matchnews){
        return match_newsMapper.addMn(matchid,newstitle,matchnews);
    }

    public int deleteMn(int matchid){
        return match_newsMapper.deleteMn(matchid);
    }

    public int updateMn(int newsid,int matchid, String newstitle,String matchnews){
        return match_newsMapper.updateMn(newsid,matchid,newstitle,matchnews);
    }
}
