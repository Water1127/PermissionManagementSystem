package cn.water.project.service;

import cn.water.project.domain.Orders;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/2 - 14:25
 * @description
 */
public interface OrdersService {

    /** 查询所有订单信息（展示） */
    List<Orders> findAll () throws Exception;

    /** 查询所有订单信息（展示），并分页 */
    List<Orders> findAllByPage (int pageNum,int pageSize) throws Exception;

    /** 根据Id，查询订单信息（详情） */
    Orders findById(String ordersId) throws Exception;

}
