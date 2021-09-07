package com.example.Controller;

import com.example.Po.student_work_management;
import com.example.Service.StudentWorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentWorksController {

    @Autowired
    StudentWorksService studentWorksService;

    @CrossOrigin
    @PostMapping(value = "/api/stuworks")
    @ResponseBody
    public List<student_work_management> stuworks(@RequestBody student_work_management stu) {
        return studentWorksService.stuallworks(stu.getStudentid());
    }
}
