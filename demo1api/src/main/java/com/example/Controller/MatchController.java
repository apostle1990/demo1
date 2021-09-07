package com.example.Controller;

import com.example.Po.match_info;
import com.example.Result.Request;
import com.example.Result.Result;
import com.example.Service.MatchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MatchController {

    @Autowired
    private MatchInfoService matchInfoService;
    @CrossOrigin
    @PostMapping(value = "/api/matchinfo")
    @ResponseBody
    public List<match_info> selectAll(@RequestBody Request request) {
        return matchInfoService.selectAll();
    }

    @CrossOrigin
    @PostMapping(value = "/api/addmatch")
    @ResponseBody
    public Result addMatch(@RequestBody match_info match_info) {
        if (matchInfoService.selectmatch(match_info.getMatchid())!=null){
            return new Result(600);
        }else if(matchInfoService.addmatch(match_info.getMatchname(),match_info.getMatchcontext(),match_info.getMatchstate())!=0){
            return new Result(200);
        }else{
            return new Result(400);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/deletematch")
    @ResponseBody
    public Result deleteMatch(@RequestBody match_info match_info) {
        if (matchInfoService.deletematch(match_info.getMatchid())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

    @CrossOrigin
    @PostMapping(value = "/api/updatematch")
    @ResponseBody
    public Result updateMatch(@RequestBody match_info match_info) {
        if (matchInfoService.updatematch(match_info.getMatchid(),match_info.getMatchname(),match_info.getMatchcontext(),match_info.getMatchstate())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }
}
