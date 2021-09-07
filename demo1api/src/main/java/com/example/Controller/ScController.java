package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

@Controller
public class ScController {

    @CrossOrigin
    @PostMapping(value = "/api/sc")
    @ResponseBody
    public void getStreamData(HttpServletResponse response) {
        File file = new File("E:\\learning\\Scratch\\Scratch作品.sb3");
        ServletOutputStream out = null;
        try {
            FileInputStream instream = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length = 0;
            BufferedInputStream buf = new BufferedInputStream(instream);
            out = response.getOutputStream();
            BufferedOutputStream bot = new BufferedOutputStream(out);
            while ((length = buf.read(b)) != -1) {
                bot.write(b, 0, b.length);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
