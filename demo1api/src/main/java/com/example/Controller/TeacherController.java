package com.example.Controller;

import com.example.Po.teacher_info;
import com.example.Result.Request;
import com.example.Result.Result;
import com.example.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @CrossOrigin
    @PostMapping(value = "/api/tlogin")
    @ResponseBody
    public Result login(@RequestBody teacher_info teacher) {
        if (teacherService.login(teacher.getTelephone(), teacher.getPassword()) != null) {
            return new Result(200,teacherService.selectteacherid(teacher.getTelephone()));
        } else {
            return new Result(400);
        }
    }
    @CrossOrigin
    @PostMapping(value = "/api/tea")
    @ResponseBody
    public List<teacher_info> selectAll(@RequestBody Request request){
        return teacherService.selectAll();
    }

    @CrossOrigin
    @PostMapping(value = "/api/addtea")
    @ResponseBody
    public Result addMatch(@RequestBody teacher_info tea) {
        if (teacherService.selecttelephone(tea.getTelephone())!=null){
            return new Result(600);
        }else if(teacherService.addteacher(tea.getTelephone(),tea.getTeachername(),tea.getPassword(),tea.getEmail(),tea.getQq())!=0){
            return new Result(200);
        }else{
            return new Result(400);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/deletetea")
    @ResponseBody
    public Result deleteMatch(@RequestBody teacher_info tea) {
        if (teacherService.deleteteacher(tea.getTeacherid())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

    @CrossOrigin
    @PostMapping(value = "/api/updatetea")
    @ResponseBody
    public Result updateMatch(@RequestBody teacher_info tea) {
        if (teacherService.updateteacher(tea.getTeacherid(),tea.getTeachername(),tea.getPassword(),tea.getEmail(),tea.getQq())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }
}
