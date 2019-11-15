package cn.water.project.service;

import cn.water.project.dao.OrdersDao;
import cn.water.project.domain.Orders;
import cn.water.project.domain.Role;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/2 - 14:25
 * @description
 */
@Service
@Transactional
public class OrdersServiceImp implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    /** 查询所有订单信息（展示） */
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }

    /** 查询所有订单信息（展示），并分页 */
    public List<Orders> findAllByPage(int pageNum, int pageSize) throws Exception {
        /* PageHelper：pageNum表示页码值，pageSize表示每页显示数。 */
        PageHelper.startPage(pageNum,pageSize);/* 此行代码必须使用于调用具体MySQL数据库操作语句之前 */
        return ordersDao.findAll();
    }

    /** 根据Id，查询订单信息（详情） */
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
