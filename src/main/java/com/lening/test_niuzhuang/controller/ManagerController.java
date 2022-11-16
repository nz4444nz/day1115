package com.lening.test_niuzhuang.controller;

import com.github.pagehelper.PageInfo;
import com.lening.test_niuzhuang.ResultInfo;
import com.lening.test_niuzhuang.entity.CompanyBean;
import com.lening.test_niuzhuang.entity.ManagerBean;
import com.lening.test_niuzhuang.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private ManagerService managerService;

    @RequestMapping("/getLogin")
    public ResultInfo getLogin(@RequestBody ManagerBean managerBean, HttpServletRequest request){
        ManagerBean  mrs=managerService.getLogin(managerBean);
        if (mrs!=null){
            request.getSession().setAttribute("manager",mrs);
            return new ResultInfo(true,"登录成功");
        }else {
            return new ResultInfo(false,"登录失败啊");
        }

    }


    @RequestMapping("/findAll")
    public PageInfo<CompanyBean> findAll(@RequestBody CompanyBean searchEntity,
                                         @RequestParam(defaultValue = "1") Integer pageNum,
                                         @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<CompanyBean> all = managerService.findAll(searchEntity, pageNum, pageSize);
        return all;
    }

    @GetMapping("/deleteManagerById")
    public ResultInfo deleteManagerById(Integer id){
        try {
            managerService.deleteManagerById(id);
            return new ResultInfo(true, "ok");
        }catch (Exception e){
            return new ResultInfo(false, "删除失败");
        }
    }

    @PostMapping("/deleteBatch")
    public ResultInfo deleteBatch(@RequestBody Integer[] cids){
        try {
            managerService.deleteBatch(cids);
            return new ResultInfo(true, "ok");
        }catch (Exception e){
            return new ResultInfo(false, "删除失败");
        }
    }
    @RequestMapping("/updateManager")
    public CompanyBean updateManager(Integer id){
        CompanyBean c =  managerService.updateManager(id);
        return c;
    }
    @PostMapping("/saveOrUpdate")
    public ResultInfo saveOrUpdate(@RequestBody CompanyBean companyBean,HttpServletRequest request){
        Object id = request.getSession().getAttribute("id");
        System.out.println(id);
        try {
            managerService.saveOrUpdate(companyBean);
            return new ResultInfo(true, "编辑成功");
        }catch (Exception e){
            return new ResultInfo(false, "编辑失败");
        }
    }

}
