package com.gwf.controller;

import com.gwf.annotation.Log;
import com.gwf.entity.Msg;
import com.gwf.entity.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Iterator;

/**
 * Created by gaowenfeng on 2017/3/31.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    @Log(name = "登录")
    public String index(Model model){
        Msg msg = new Msg("测试标题","测试内容","额外信息，只对管理员显示");
        model.addAttribute("msg",msg);
        return "home";
    }
}
