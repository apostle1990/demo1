package com.example.Controller;

import com.example.Po.teacher_info;
import com.example.Po.teacher_match;
import com.example.Result.MatchTeacher;
import com.example.Result.Request;
import com.example.Result.Result;
import com.example.Service.TeacherMatchService;
import com.example.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherMatchController {

    @Autowired
    TeacherMatchService teacherMatchService;

    @Autowired
    TeacherService teacherService;

    @CrossOrigin
    @PostMapping(value = "/api/teamatch")
    @ResponseBody
    public List<MatchTeacher> selectTeacher(@RequestBody teacher_match teacher_match){
        List<MatchTeacher> matchTeachers = new ArrayList<>();
        List<teacher_match> teacherMatches =teacherMatchService.selectteacher(teacher_match.getMatchid());
        for (int i=0;i<teacherMatches.size();i++){
            MatchTeacher mt = new MatchTeacher();
            mt.setTeacherid(teacherMatches.get(i).getTeacherid());
            mt.setTeachername(teacherMatchService.selectTeacher(teacherMatches.get(i).getTeacherid()).getTeachername());
            matchTeachers.add(mt);
        }
        return matchTeachers;
    }

    @CrossOrigin
    @PostMapping(value = "/api/inteamatch")
    @ResponseBody
    public List<MatchTeacher> selectOtherTeacher(@RequestBody teacher_match teacher_match){
        List<MatchTeacher> matchTeachers = new ArrayList<>();
        //当前比赛教师ID
        List<teacher_match> teacherMatches =teacherMatchService.selectteacher(teacher_match.getMatchid());
        //所有教师ID
        List<teacher_info> teacher_infos = teacherService.selectAll();
        boolean tm=true;
        for(int j=0;j<teacher_infos.size();j++){
            MatchTeacher mt = new MatchTeacher();
            for (int i=0;i<teacherMatches.size();i++){
                if (teacherMatches.get(i).getTeacherid()==teacher_infos.get(j).getTeacherid()){
                    tm = false;
                    break;
                }
            }
            if (tm){
                mt.setTeacherid(teacher_infos.get(j).getTeacherid());
                mt.setTeachername(teacher_infos.get(j).getTeachername());
                if (!matchTeachers.contains(mt)){
                    matchTeachers.add(mt);
                }
            }
            tm=true;
        }
        return matchTeachers;
    }

    @CrossOrigin
    @PostMapping(value = "/api/deleteteamatch")
    @ResponseBody
    public Result deletemt(@RequestBody teacher_match teacher_match){
        if (teacherMatchService.deletemt(teacher_match.getMatchid(),teacher_match.getTeacherid())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

    @CrossOrigin
    @PostMapping(value = "/api/addteamatch")
    @ResponseBody
    public Result addemt(@RequestBody teacher_match teacher_match){
        if (teacherMatchService.addmt(teacher_match.getMatchid(),teacher_match.getTeacherid())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }
}
