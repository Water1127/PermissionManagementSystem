package cn.water.project.controller;

import cn.water.project.domain.Product;
import cn.water.project.domain.UserInfo;
import cn.water.project.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/1 - 14:32
 * @description
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /** 查询所有产品信息（展示） */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        /* 创建 ModelAndView对象 */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层的方法 */
        List<Product> products = productService.findAll();
        /* 存储 */
        mv.addObject("productList",products);
        /* 跳转 */
        mv.setViewName("product-list");
        return mv;
    }

    /** 查询所有产品信息（展示），并分页 */
    @RequestMapping("/findAllByPage.do")
    public ModelAndView findAllByPage(
            @RequestParam(name = "pageNum",required = true,defaultValue = "1")Integer pageNum,
            @RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize
    ) throws Exception {
        /* 创建 ModelAndView对象 */
        ModelAndView mv = new ModelAndView();
        /* 调用 Service层方法 */
        List<Product> products = productService.findAllByPage(pageNum,pageSize);
        /* 获取PageInfo（分页Bean） */
        PageInfo pageInfo = new PageInfo(products);
        /* 存储 */
        mv.addObject("pageInfo",pageInfo);
        /* 跳转 */
        mv.setViewName("product-list");
        /* 返回 */
        return mv;
    }


    /** 添加新产品（添加） */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        /* 调用Service层方法 */
        productService.save(product);
        /* 跳转 */
        return "redirect:findAll.do";
    }


}
