package com.example.Controller;

import com.example.Po.match_info;
import com.example.Po.teacher_match;
import com.example.Po.teacher_score;
import com.example.Result.Result;
import com.example.Service.TeacherScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherScoreController {

    @Autowired
    TeacherScoreService teacherScoreService;

    @CrossOrigin
    @PostMapping(value = "/api/matchtea")
    @ResponseBody
    public List<match_info> selectmatch(@RequestBody teacher_match teacher_match){
        return teacherScoreService.selectmatch(teacher_match.getTeacherid());
    }

    @CrossOrigin
    @PostMapping(value = "/api/setscore")
    @ResponseBody
    public Result setscore(@RequestBody teacher_score teacher_score){
        System.out.println(teacher_score.getTeacherid());
        System.out.println(teacher_score.getMatchid());
        System.out.println(teacher_score.getWorksid());
        System.out.println(teacher_score.getTeacherscore());
        if (teacherScoreService.setscore(teacher_score)!=0){
            return new Result(200);
        }else{
            return new Result(400);
        }
    }
}
