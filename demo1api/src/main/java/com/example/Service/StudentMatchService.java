package com.example.Service;

import com.example.Dao.match_infoMapper;
import com.example.Dao.student_matchMapper;
import com.example.Dao.student_work_managementMapper;
import com.example.Po.match_info;
import com.example.Po.student_match;
import com.example.Result.Stumatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentMatchService {

    @Autowired
    student_matchMapper student_matchMapper;

    @Autowired
    match_infoMapper match_infoMapper;

    @Autowired
    student_work_managementMapper student_work_managementMapper;

    public List<Stumatch> stumatch(int studentid){
        List<Stumatch> stumatchList = new ArrayList<>();
        List<student_match> studentMatches=student_matchMapper.stumatch(studentid);
        for (int i=0;i<studentMatches.size();i++){
            Stumatch stumatch = new Stumatch();
            stumatch.setMatchid(studentMatches.get(i).getMatchid());
            //比赛名
            stumatch.setMatchname(match_infoMapper.selectmatch(studentMatches.get(i).getMatchid()).getMatchname());
            //作品名
            stumatch.setWorkstitle(student_work_managementMapper.stualloneworks(studentMatches.get(i).getWorksid()).getWorkstitle());
            //分数
            stumatch.setScore(studentMatches.get(i).getScore());
            stumatchList.add(stumatch);
        }
        return stumatchList;
    }
}
