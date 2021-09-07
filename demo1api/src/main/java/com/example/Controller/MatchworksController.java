package com.example.Controller;

import com.example.Po.student_match;
import com.example.Po.student_work_management;
import com.example.Result.Result;
import com.example.Result.Worksmanage;
import com.example.Service.MatchWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MatchworksController {

    @Autowired
    MatchWorksService matchWorksService;

    @CrossOrigin
    @PostMapping(value = "/api/matchworks")
    @ResponseBody
    public List<Worksmanage> selectAll(@RequestBody student_match student_match){
        List<Worksmanage> worksmanages = new ArrayList<>();
        List<student_match> stumatch = matchWorksService.selectmatch(student_match.getMatchid());
        for(int i=0;i<stumatch.size();i++){
            Worksmanage work = new Worksmanage();
            //学生id,学生名
            work.setStudentid(stumatch.get(i).getStudentid());
            work.setStudentname(matchWorksService.stuname(stumatch.get(i).getStudentid()));
            //作品ID，作品名、作品内容
            work.setWorksid(stumatch.get(i).getWorksid());
            work.setWorkstitle(matchWorksService.stuworks(stumatch.get(i).getWorksid(),stumatch.get(i).getStudentid()).getWorkstitle());
            work.setWorkscontext(matchWorksService.stuworks(stumatch.get(i).getWorksid(),stumatch.get(i).getStudentid()).getWorkscontext());
            //成绩
            work.setScore(matchWorksService.stuscore(student_match.getMatchid(),stumatch.get(i).getWorksid(),stumatch.get(i).getStudentid()));
            worksmanages.add(work);
        }
        return worksmanages;
    }

    @CrossOrigin
    @PostMapping(value = "/api/deleteworks")
    @ResponseBody
    public Result deleteworks(@RequestBody student_match student_match){
        if (matchWorksService.deleteStuworks(student_match.getMatchid(),student_match.getStudentid())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

    @CrossOrigin
    @PostMapping(value = "/api/updateworks")
    @ResponseBody
    public Result updateworks(@RequestBody student_match student_match){
        if (matchWorksService.updateStuworks(student_match.getMatchid(),student_match.getStudentid(),student_match.getScore())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }
}
