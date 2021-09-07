package com.example.Controller;

import com.example.Po.student_info;
import com.example.Po.student_match;
import com.example.Result.Stumatch;
import com.example.Service.StudentMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentMatchController {

    @Autowired
    StudentMatchService studentMatchService;

    @CrossOrigin
    @PostMapping(value = "/api/stumatchinfo")
    @ResponseBody
    public List<Stumatch> getStu(@RequestBody student_match stu){
        return studentMatchService.stumatch(stu.getStudentid());
    }
}
