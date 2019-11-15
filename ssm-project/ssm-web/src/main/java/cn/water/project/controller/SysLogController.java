package cn.water.project.controller;

import cn.water.project.domain.SysLog;
import cn.water.project.domain.UserInfo;
import cn.water.project.service.SysLogService;
import cn.water.project.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/8 - 15:19
 * @description
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService logService;

    /** 查询所有用户信息（展示） */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        /* 创建 ModelAndView */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        List<SysLog> logs = logService.findAll();
        /* 存储 */
        mv.addObject("syslog",logs);
        /* 跳转 */
        mv.setViewName("syslog-list");
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
        List<SysLog> logs = logService.findAllByPage(pageNum,pageSize);
        /* 获取PageInfo（分页Bean） */
        PageInfo pageInfo = new PageInfo(logs);
        /* 存储 */
        mv.addObject("pageInfo",pageInfo);
        /* 跳转 */
        mv.setViewName("syslog-list");
        /* 返回 */
        return mv;
    }


}
