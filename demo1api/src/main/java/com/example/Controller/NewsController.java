package com.example.Controller;

import com.example.Po.match_news;
import com.example.Result.Request;
import com.example.Result.Result;
import com.example.Service.MatchNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private MatchNewsService  matchNewsService;

    @CrossOrigin
    @PostMapping(value = "/api/news")
    @ResponseBody
    public List<match_news> selectAll(@RequestBody Request request) {
        return matchNewsService.selectAll();
    }

    @CrossOrigin
    @PostMapping(value = "/api/addnews")
    @ResponseBody
    public Result addMatch(@RequestBody match_news match_news) {
        if(matchNewsService.addMn(match_news.getMatchid(),match_news.getNewstitle(),match_news.getMatchnews())!=0){
            return new Result(200);
        }else{
            return new Result(400);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/api/deletenews")
    @ResponseBody
    public Result deleteMatch(@RequestBody match_news match_news) {
        if (matchNewsService.deleteMn(match_news.getNewsid())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

    @CrossOrigin
    @PostMapping(value = "/api/updatenews")
    @ResponseBody
    public Result updateMatch(@RequestBody match_news match_news) {
        if (matchNewsService.updateMn(match_news.getNewsid(),match_news.getMatchid(),match_news.getNewstitle(),match_news.getMatchnews())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }
}
