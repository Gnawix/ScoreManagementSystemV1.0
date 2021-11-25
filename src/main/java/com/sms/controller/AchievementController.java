package com.sms.controller;

import com.sms.pojo.Achievement;
import com.sms.pojo.SC;
import com.sms.pojo.User;
import com.sms.service.AchievementService;
import com.sms.service.SCService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AchievementController {

    @Autowired
    private AchievementService achievementService;
    @Autowired
    private SCService scService;

    @RequestMapping("/allScore")
    public String allScore(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user != null){
            model.addAttribute("username", user.getUsername());
        }
        List<Achievement> list = achievementService.queryAllAchievement();
        model.addAttribute("list", list);
        return "allScore";
    }

    @GetMapping("/queryScoreByTeacherID")
    public String queryScoreByTeacherID(Model model, String id) {
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        List<Achievement> list;
        if ("admin".equals(currentUser.getPerms())) {
            list = achievementService.queryAchievementByTeacherID(id);
        }else {
            list = achievementService.queryAchievementByTeacherID(currentUser.getUsername());
        }
        model.addAttribute("list", list);
        return "allScore";


    }

    @GetMapping("/queryScoreByStudentID")
    public String queryScoreByStudentID(Model model, String id) {
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        List<Achievement> list;
        if ("admin".equals(currentUser.getPerms())) {
            list = achievementService.queryAchievementByStudentID(id);
        }else {
            list = achievementService.queryAchievementByStudentID(currentUser.getUsername());
        }
        model.addAttribute("list", list);
        return "allScore";
    }

    @GetMapping("/queryScoreByStudentName")
    public String queryScoreByStudentName(Model model, String id) {
        List<Achievement> list = achievementService.queryAchievementByStudentName(id);
        model.addAttribute("list", list);
        return "allScore";
    }

    @GetMapping("/queryScoreByCourseName")
    public String queryScoreByCourseName(Model model, String id) {
        List<Achievement> list = achievementService.queryAchievementByCourseName(id);
        model.addAttribute("list", list);
        return "allScore";
    }

    @PostMapping("/updateScore")
    public String updateScore(SC sc, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        scService.updateSC(sc);
        if("teacher".equals(currentUser.getPerms())){
            return "redirect:/queryScoreByTeacherID";
        }else if("student".equals(currentUser.getPerms())){
            return "redirect:/queryScoreByStudentID";
        }
//        return "redirect:/allScore";
        String ref = request.getHeader("REFERER");
        ref="redirect:"+ref;
        return ref;
    }

}
