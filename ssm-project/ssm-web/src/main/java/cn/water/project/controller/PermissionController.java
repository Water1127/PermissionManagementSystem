package cn.water.project.controller;


import cn.water.project.domain.Permission;
import cn.water.project.domain.UserInfo;
import cn.water.project.service.PermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/6 - 17:12
 * @description
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    /** 查询所有权限信息（展示） */
    @RequestMapping("/findAll.do")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")/** 权限控制 */
    public ModelAndView findAll() throws Exception{
        /* 创建 ModelAndView */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        List<Permission> permissions = permissionService.findAll();
        /* 存储 */
        mv.addObject("permissionList",permissions);
        /* 跳转 */
        mv.setViewName("permission-list");
        /* 返回 */
        return mv;
    }

    /** 查询所有权限信息（展示），并分页 */
    @RequestMapping("/findAllByPage.do")
    public ModelAndView findAllByPage(
            @RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum,
            @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize
    ) throws Exception {
        /* 创建 ModelAndView对象 */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        List<Permission> permissions = permissionService.findAllByPage(pageNum,pageSize);
        /* 获取PageInfo（分页Bean） */
        PageInfo pageInfo = new PageInfo(permissions);
        /* 存储 */
        mv.addObject("pageInfo",pageInfo);
        /* 跳转 */
        mv.setViewName("permission-list");
        /* 返回 */
        return mv;
    }


    /** 添加新权限（添加） */
    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username=='cat'")/** 权限控制 */
    public String save(Permission permission) throws Exception{
        /* 调用 Service层方法 */
        permissionService.save(permission);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }


    /** 根据id，查询权限信息（详情） */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception{
        /* 创建 ModelAndView */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        Permission permission = permissionService.findById(id);
        /* 存储 */
        mv.addObject("permission",permission);
        /* 跳转 */
        mv.setViewName("permission-show");
        /* 返回 */
        return mv;
    }


    /** 根据id，删除单个用户（删除） */
    @RequestMapping("/deletePermissionById.do")
    public String deletePermissionById(
            @RequestParam(name = "id",required = true) String permissionId) throws Exception{
        /* 调用 Service层方法 */
        permissionService.deletePermissionById(permissionId);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }

    /** 根据id，删除多个用户（删除） */
    @RequestMapping("/deletePermissionListById.do")
    public String deletePermissionListById(
            @RequestParam(name = "ids",required = true) String[] permissionIdList) throws Exception{
        /* 调用 Service层方法 */
        permissionService.deletePermissionListById(permissionIdList);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }



}
