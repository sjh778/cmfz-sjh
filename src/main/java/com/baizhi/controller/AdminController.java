package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService service;
    @RequestMapping("/login")
    @ResponseBody
    public Map login(HttpSession session,String vrifyCode, String username, String password){
        Map map = service.login(username,password);

        String realKaptcha = (String) session.getAttribute("vrifyCode");
        System.out.println("用户输入的验证码"+vrifyCode);
        System.out.println("生成的验证码"+realKaptcha);
        if(realKaptcha.equalsIgnoreCase(vrifyCode)){
            map.put("yzm",true);

        }else{
            map.put("yzm",false);

        }
        return map;
    }
}
