package com.example.Service;

import com.example.Dao.messageMapper;
import com.example.Po.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    messageMapper messageMapper;

    public List<message> SelectAll(){
        return messageMapper.SelectAll();
    }

    public List<message> SelectOne(String ts){
        return messageMapper.SelectOne(ts);
    }

    public message selectmessage(int contextid){
        return messageMapper.selectmessage(contextid);
    }

    public int addmessage(String context,String ts){
        return messageMapper.addmessage(context,ts);
    }

    public int deletemessage(int contextid){
        return messageMapper.deletemessage(contextid);
    }

    public int updatemessage(int contextid,String context,String ts){
        return messageMapper.updatemessage(contextid,context,ts);
    }

}



