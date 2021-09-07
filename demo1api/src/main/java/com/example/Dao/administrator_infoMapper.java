package com.example.Dao;

import com.example.Po.administrator_info;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface administrator_infoMapper {
    administrator_info login(int administratorid,String password);

    List<administrator_info> selectAll();

    administrator_info selectadid(int administratorid);

    int addAD(int administratorid ,String password);

    int deleteAD(int administratorid);

    int updateAD(int administratorid,String password);
}