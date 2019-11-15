package cn.water.project.dao;

import cn.water.project.domain.Member;
import cn.water.project.domain.Orders;
import cn.water.project.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/2 - 14:25
 * @description
 */
public interface OrdersDao {


    /** 查询所有订单信息（展示） */
    @Select("SELECT * FROM orders")
    @Results(
        id = "orderMap01",
        value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(/*（4）*/property = "product",
                    /*（1）*/column = "productId",
                    /*（3）*/javaType = Product.class,
                    /*（2）*/one = @One(select = "cn.water.project.dao.ProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;


    /** 根据Id，查询订单信息（详情） */
    @Select("SELECT * FROM orders WHERE id = #{ordersId}")
    @Results(
        id = "orderMap02",
        value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            /* 1、获取productId字段 */
            /* 2、按照productId字段，查询对应的product信息（单表） */
            /* 3、封装至Product实体类 */
            /* 4、赋值给product成员变量 */
            @Result(/*（4）*/property = "product",
                    /*（1）*/column = "productId",
                    /*（3）*/javaType = Product.class,
                    /*（2）*/one = @One(select = "cn.water.project.dao.ProductDao.findById")),
            /* 1、获取memberId字段 */
            /* 2、按照memberId字段，查询对应的member信息（单表） */
            /* 3、封装至Member实体类 */
            /* 4、赋值给member成员变量 */
            @Result(/*（4）*/property = "member",
                    /*（1）*/column = "memberId",
                    /*（3）*/javaType = Member.class,
                    /*（2）*/one = @One(select = "cn.water.project.dao.MemberDao.findById")),
            /* 1、获取id字段 */
            /* 2、按照id字段，查询对应的traveller信息（多表） */
            /* 3、封装至List集合 */
            /* 4、赋值给travellers成员变量 */
            @Result(/*（4）*/property = "travellers",
                    /*（1）*/column = "id",
                    /*（3）*/javaType = List.class,
                    /*（2）*/many = @Many(select = "cn.water.project.dao.TravellerDao.findByOrderId")
            )
    })
    Orders findById(String ordersId) throws Exception;

}
