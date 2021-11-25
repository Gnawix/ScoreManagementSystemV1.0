package com.sms.controller;

import com.sms.pojo.User;
import com.sms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping({"/", "/index.html"})
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //用户登录
            subject.login(token);
            User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
            if (currentUser.getPerms().equals("teacher")) {
                return "redirect:queryScoreByTeacherID";
            } else if (currentUser.getPerms().equals("student")) {
                return "redirect:queryScoreByStudentID";
            } else {
                return "redirect:/allScore";
            }
        } catch (UnknownAccountException uae) {
            //如果用户名不存在
            System.out.println("用户名不存在");
            model.addAttribute("exception", "用户名不存在");
            return "index";
        } catch (IncorrectCredentialsException ice) {
            //如果密码错误
            System.out.println("密码错误");
            model.addAttribute("exception", "密码错误");
            return "index";
        }
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized() {
        return "未经授权无法访问！";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/updatePassword")
    public String updatePassword(String username, String password,Model model){
        userService.updatePassword(username, password);
        model.addAttribute("exception", "密码修改成功，请重新登陆");
        return "index";
    }
}
