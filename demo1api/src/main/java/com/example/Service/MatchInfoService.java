package com.example.Service;

import com.example.Dao.match_infoMapper;
import com.example.Po.match_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchInfoService {

    @Autowired
    com.example.Dao.match_infoMapper match_infoMapper;
    public List<match_info> selectAll(){
        return match_infoMapper.SelectAll();
    }

    public match_info selectmatch(int matchid){
        return match_infoMapper.selectmatch(matchid);
    }

    public int addmatch(String matchname,String matchcontext,String matchstate){
        return match_infoMapper.addmatch(matchname,matchcontext,matchstate);
    }

    public int deletematch(int matchid){
        return match_infoMapper.deletematch(matchid);
    }

    public int updatematch(int matchid,String matchname,String matchcontext,String matchstate){
        return match_infoMapper.updatematch(matchid,matchname,matchcontext,matchstate);
    }
}
