package cn.water.project.controller;


import cn.water.project.domain.Permission;
import cn.water.project.domain.Role;
import cn.water.project.domain.UserInfo;
import cn.water.project.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /** 查询所有角色信息（展示） */
    @RequestMapping("/findAll.do")
    @Secured({"ROLE_USER","ROLE_ADMIN"})/** 权限控制 */
    public ModelAndView findAll() throws Exception{
        /* 创建 ModelAndView */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        List<Role> roles = roleService.findAll();
        /* 存储 */
        mv.addObject("roleList",roles);
        /* 跳转 */
        mv.setViewName("role-list");
        /* 返回 */
        return mv;
    }

    /** 查询所有角色信息（展示），并分页 */
    @RequestMapping("/findAllByPage.do")
    public ModelAndView findAllByPage(
            @RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum,
            @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize
    ) throws Exception {
        /* 创建 ModelAndView对象 */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        List<Role> roles = roleService.findAllByPage(pageNum,pageSize);
        /* 获取PageInfo（分页Bean） */
        PageInfo pageInfo = new PageInfo(roles);
        /* 存储 */
        mv.addObject("pageInfo",pageInfo);
        /* 跳转 */
        mv.setViewName("role-list");
        /* 返回 */
        return mv;
    }


    /** 添加新角色（添加） */
    @RequestMapping("/save.do")
    @Secured("ROLE_ADMIN")/** 权限控制 */
    public String save(Role role) throws Exception{
        /* 调用 Service层方法 */
        roleService.save(role);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }


    /** 根据id，查询角色信息（详情） */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception{
        /* 创建 ModelAndView */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        Role role = roleService.findById(id);
        /* 存储 */
        mv.addObject("role",role);
        /* 跳转 */
        mv.setViewName("role-show");
        /* 返回 */
        return mv;
    }

    /** 根据id，查询角色可以关联的权限（关联权限） */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(String id) throws Exception{
        /* 创建 ModelAndView */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        Role role = roleService.findById(id);
        List<Permission> otherPermission = roleService.findOtherPermission(id);
        /* 存储 */
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermission);
        /* 跳转 */
        mv.setViewName("role-permission-add");
        /* 返回 */
        return mv;
    }

    /** 添加角色和权限的关联（关联权限） */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(
            @RequestParam(name = "roleId",required = true) String roleId,
            @RequestParam(name = "ids",required = true) String[] permissionIdList) throws Exception{
        /* 调用 Service层方法 */
        roleService.addPermissionToRole(roleId,permissionIdList);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }

    /** 根据id，删除单个角色（删除） */
    @RequestMapping("/deleteRoleById.do")
    public String deleteRoleById(
            @RequestParam(name = "id",required = true) String roleId) throws Exception{
        /* 调用 Service层方法 */
        roleService.deleteRoleById(roleId);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }

    /** 根据id，删除多个角色（删除） */
    @RequestMapping("/deleteRoleListById.do")
    public String deleteRoleListById(
            @RequestParam(name = "ids",required = true) String[] roleIdList) throws Exception{
        /* 调用 Service层方法 */
        roleService.deleteRoleListById(roleIdList);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }




}
