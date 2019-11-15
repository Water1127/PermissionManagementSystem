package cn.water.project.controller;

import cn.water.project.domain.Orders;
import cn.water.project.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/2 - 14:25
 * @description
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /** 查询所有订单信息（展示） */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        /* 创建 ModelAndView对象 */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层的方法 */
        List<Orders> orders = ordersService.findAll();
        /* 存储 */
        mv.addObject("ordersList",orders);
        /* 跳转 */
        mv.setViewName("orders-list");
        /* 返回 */
        return mv;
    }

    /** 查询所有订单信息（展示），并分页 */
    @RequestMapping("/findAllByPage.do")
    public ModelAndView findAllByPage(
            @RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum,
            @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize
    ) throws Exception {
        /* 创建 ModelAndView对象 */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层的方法 */
        List<Orders> orders = ordersService.findAllByPage(pageNum,pageSize);
        /* 获取PageInfo（分页Bean） */
        PageInfo pageInfo = new PageInfo(orders);
        /* 存储 */
        mv.addObject("pageInfo",pageInfo);
        /* 跳转 */
        mv.setViewName("orders-page-list");
        /* 返回 */
        return mv;
    }

    /** 根据Id，查询订单信息（详情） */
    @RequestMapping("/findById.do")
    public ModelAndView findById(
            @RequestParam(name = "orderId",required = true)String orderId
    ) throws Exception{
        /* 创建 ModelAndView对象 */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层的方法 */
        Orders orders = ordersService.findById(orderId);
        /* 存储 */
        mv.addObject("orders",orders);
        /* 跳转 */
        mv.setViewName("orders-show");
        /* 返回 */
        return mv;
    }


}
