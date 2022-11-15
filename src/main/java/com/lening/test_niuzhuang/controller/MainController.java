package com.lening.test_niuzhuang.controller;

import com.lening.test_niuzhuang.entity.CompanyBean;
import com.lening.test_niuzhuang.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/main")
public class MainController {
    @Resource
    private ManagerService managerService;
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("/toList")
    public String toMain(){
        return "list";
    }
    @RequestMapping("/insertManager")
    public String insertManager(){
        return "insert";
    }
    @GetMapping("/updateManager")
    public String updateManager(Integer id,HttpServletRequest request){
        System.out.println("id:"+id);
        request.getSession().setAttribute("id",id);
        return "update";
    }

}
