package com.example.music.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.music.domain.Singer;
import com.example.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    /**
     * 添加歌手
     */
    @RequestMapping("/add")
    public Object addSinger(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex").trim();
        /*头像*/
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        /*日期转换*/
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //保存到歌手的对象中
        Singer singer = new Singer();
        singer.setName(name);
        /*强制转换为byte*/
        singer.setSex(new Byte(sex));
        singer.setBirth(birthDate);
        singer.setPic(pic);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        boolean flag = singerService.insert(singer);
        if (flag){ //保存成功
            jsonObject.put("code",1);
            jsonObject.put("msg","添加成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","添加失败");
        return jsonObject;
    }

    /**
     * 修改歌手
     */
    @RequestMapping("/update")
    public JSONObject updateSinger(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String id = request.getParameter("id").trim();
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex").trim();
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();
        DateFormat dateFormat = new SimpleDateFormat();
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Singer singer = new Singer();
        singer.setId(new Integer(id));
        singer.setName(name);
        singer.setBirth(birthDate);
        singer.setSex(new Byte(sex));
        singer.setPic(pic);
        singer.setLocation(location);
        singer.setIntroduction(introduction);
        boolean flag = singerService.update(singer);
        if (flag){
            jsonObject.put("code",1);
            jsonObject.put("msg","修改成功");
            return jsonObject;
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","修改失败");
        return jsonObject;
    }

}
