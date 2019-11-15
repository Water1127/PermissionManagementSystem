package cn.water.project.controller;


import cn.water.project.domain.Role;
import cn.water.project.domain.UserInfo;
import cn.water.project.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author Water
 * @date 2019/11/4 - 19:11
 * @description
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /** 查询所有用户信息（展示） */
    @RequestMapping("/findAll.do")
    @RolesAllowed({"ADMIN","USER"})/** 权限控制 */
    public ModelAndView findAll() throws Exception{
        /* 创建 ModelAndView */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        List<UserInfo> users = userService.findAll();
        /* 存储 */
        mv.addObject("userList",users);
        /* 跳转 */
        mv.setViewName("user-list");
        /* 返回 */
        return mv;
    }

    /** 查询所有用户信息（展示），并分页 */
    @RequestMapping("/findAllByPage.do")
    public ModelAndView findAllByPage(
            @RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum,
            @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize
    ) throws Exception {
        /* 创建 ModelAndView对象 */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        List<UserInfo> users = userService.findAllByPage(pageNum,pageSize);
        /* 获取PageInfo（分页Bean） */
        PageInfo pageInfo = new PageInfo(users);
        /* 存储 */
        mv.addObject("pageInfo",pageInfo);
        /* 跳转 */
        mv.setViewName("user-list");
        /* 返回 */
        return mv;
    }


    /** 添加新用户（添加） */
    @RequestMapping("/save.do")
    @RolesAllowed("ADMIN")/** 权限控制 */
//    @PreAuthorize("authentication.principal.username=='cat'")
    public String save(UserInfo userInfo) throws Exception{
        /* 调用 Service层方法 */
        userService.save(userInfo);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }

    /** 根据id，查询用户信息（详情） */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception{
        /* 创建 ModelAndView */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        UserInfo user = userService.findById(id);
        /* 存储 */
        mv.addObject("user",user);
        /* 跳转 */
        mv.setViewName("user-show");
        /* 返回 */
        return mv;
    }

    /** 查询用户可以关联角色（关联角色） */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception{
        /* 创建 ModelAndView */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        UserInfo user = userService.findById(id);
        List<Role> otherRoles = userService.findOtherRoles(id);
        /* 存储 */
        mv.addObject("user",user);
        mv.addObject("roleList",otherRoles);
        /* 跳转 */
        mv.setViewName("user-role-add");
        /* 返回 */
        return mv;
    }

    /** 查询用户可以关联角色（关联角色） */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(
            @RequestParam(name = "userId",required = true) String userId,
            @RequestParam(name = "ids",required = true) String[] roleIdList) throws Exception{
        /* 调用 Service层方法 */
        userService.addRoleToUser(userId,roleIdList);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }

    /** 根据id，删除单个用户（删除） */
    @RequestMapping("/deleteUserById.do")
    public String deleteUserById(
            @RequestParam(name = "id",required = true) String userId) throws Exception{
        /* 调用 Service层方法 */
        userService.deleteUserById(userId);
        System.out.println(userId);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }

    /** 根据id，删除多个用户（删除） */
    @RequestMapping("/deleteUserListById.do")
    public String deleteUserListById(
            @RequestParam(name = "ids",required = true) String[] userIdList) throws Exception{
        /* 调用 Service层方法 */
        userService.deleteUserListById(userIdList);
        /* 返回 */
        return "redirect:findAllByPage.do";
    }



}
