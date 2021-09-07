package com.example.Controller;

import com.example.Po.match_info;
import com.example.Po.student_info;
import com.example.Result.Request;
import com.example.Result.Result;
import com.example.Service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentservice;

    @CrossOrigin
    @PostMapping(value = "/api/slogin")
    @ResponseBody
    public Result login(@RequestBody student_info stu){
        if (studentservice.login(stu.getTelephone(),stu.getPassword())!=null){
            return new Result(200,studentservice.stuid(stu.getTelephone()));
        }else{
            return new Result(400);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/register")
    @ResponseBody
    public Result register(@RequestBody student_info stu){
        if (studentservice.login(stu.getTelephone(),stu.getPassword())!=null){
            {
                return new Result(400);
            }
        }else if (studentservice.register(stu.getTelephone(),stu.getPassword())!=0){
            return new Result(200);
        }else{
            return new Result(600);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/getstu")
    @ResponseBody
    public student_info getStu(@RequestBody student_info stu){
        return studentservice.stuinfo(stu.getStudentid());
    }

    @CrossOrigin
    @PostMapping(value = "/api/stu")
    @ResponseBody
    public List<student_info> selectAll(@RequestBody Request request){
        return studentservice.selectAll();
    }

    @CrossOrigin
    @PostMapping(value = "/api/addstu")
    @ResponseBody
    public Result addMatch(@RequestBody student_info stu) {
        if (studentservice.selecttelephone(stu.getTelephone())!=null){
            return new Result(600);
        }else if(studentservice.addstu(stu)!=0){
            return new Result(200);
        }else{
            return new Result(400);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/deletestu")
    @ResponseBody
    public Result deleteMatch(@RequestBody student_info stu) {
        if (studentservice.deletestu(stu.getStudentid())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

    @CrossOrigin
    @PostMapping(value = "/api/updatestu")
    @ResponseBody
    public Result updateMatch(@RequestBody student_info stu) {
        if (studentservice.updatestu(stu)!=0){
            return new Result(200);
        }else {return new Result(400);}
    }
}
