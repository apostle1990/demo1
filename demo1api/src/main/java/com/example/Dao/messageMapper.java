package com.example.Dao;

import com.example.Po.message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface messageMapper {
    List<message> SelectAll();

    List<message> SelectOne(String ts);

    message selectmessage(int contextid);

    int addmessage(String context,String ts);

    int deletemessage(int contextid);

    int updatemessage(int contextid,String context,String ts);
}