package com.example.Controller;

import com.example.Po.administrator_info;
import com.example.Result.Request;
import com.example.Result.Result;
import com.example.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @CrossOrigin
    @PostMapping(value = "/api/mlogin")
    @ResponseBody
    public Result login(@RequestBody administrator_info admin) {
        if (adminService.login(admin.getAdministratorid(), admin.getPassword()) != null) {
            return new Result(200);
        } else {
            return new Result(400);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/adm")
    @ResponseBody
    public List<administrator_info> selectAll(@RequestBody Request request){
        return adminService.selectAll();
    }

    @CrossOrigin
    @PostMapping(value = "/api/addadm")
    @ResponseBody
    public Result addAD(@RequestBody administrator_info tea) {
        if (adminService.selectadid(tea.getAdministratorid())!=null){
            return new Result(600);
        }else if(adminService.addAD(tea.getAdministratorid(),tea.getPassword())!=0){
            return new Result(200);
        }else{
            return new Result(400);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/deleteadm")
    @ResponseBody
    public Result deleteAD(@RequestBody administrator_info tea) {
        if (adminService.deleteAD(tea.getAdministratorid())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

    @CrossOrigin
    @PostMapping(value = "/api/updateadm")
    @ResponseBody
    public Result updateAD(@RequestBody administrator_info tea) {
        if (adminService.updateAD(tea.getAdministratorid(),tea.getPassword())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }
}
