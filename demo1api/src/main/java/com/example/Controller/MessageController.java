package com.example.Controller;

import com.example.Po.message;
import com.example.Result.Result;
import com.example.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @CrossOrigin
    @PostMapping(value = "/api/message")
    @ResponseBody
    public List<message> SelectAll(@RequestBody message message){
        return messageService.SelectAll();
    }

    @CrossOrigin
    @PostMapping(value = "/api/onemessage")
    @ResponseBody
    public List<message> SelectOne(@RequestBody message message){
        return messageService.SelectOne(message.getTs());
    }

    @CrossOrigin
    @PostMapping(value = "/api/addmessage")
    @ResponseBody
    public Result addmessage(@RequestBody message message){
        if (messageService.addmessage(message.getContext(),message.getTs())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

    @CrossOrigin
    @PostMapping(value = "/api/deletemessage")
    @ResponseBody
    public Result deletemessage(@RequestBody message message){
        if (messageService.deletemessage(message.getContextid())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

    @CrossOrigin
    @PostMapping(value = "/api/updatemessage")
    @ResponseBody
    public Result updatemessage(@RequestBody message message){
        if (messageService.updatemessage(message.getContextid(),message.getContext(),message.getTs())!=0){
            return new Result(200);
        }else {return new Result(400);}
    }

}
