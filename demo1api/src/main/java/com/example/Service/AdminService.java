package com.example.Service;

import com.example.Dao.administrator_infoMapper;
import com.example.Po.administrator_info;
import com.example.Po.administrator_info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    com.example.Dao.administrator_infoMapper administrator_infoMapper;

    public administrator_info login(int administratorId, String password){
        return  administrator_infoMapper.login(administratorId,password);
    }

    public List<administrator_info> selectAll(){
        return administrator_infoMapper.selectAll();
    }
    public administrator_info selectadid(int administratorid){
        return administrator_infoMapper.selectadid(administratorid);
    }

    public int addAD(int administratorid ,String password){
        return administrator_infoMapper.addAD(administratorid,password);
    }

    public int deleteAD(int administratorid){

        return administrator_infoMapper.deleteAD(administratorid);
    }

    public int updateAD(int administratorid,String password) {
        return administrator_infoMapper.updateAD(administratorid,password);
    }
}
