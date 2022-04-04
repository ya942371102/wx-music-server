package com.example.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.music.service.AdminService;
import com.example.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 判断是否登录成功
     */
    @RequestMapping(value = "/admin/login/status", method = RequestMethod.GET)
    public Object loginStatus(HttpServletRequest request, HttpSession session){
        /*引入阿里巴巴的fastJson*/
        JSONObject jsonObject = new JSONObject();
        /*用户，密码*/
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        /*判断结果*/
        boolean flag = adminService.verifyPassword(name,password);

        if (flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"登录成功");
            session.setAttribute(Consts.NAME,name);
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"用户名或密码错误");
        return jsonObject;
    }

}
