package cn.water.project.service;

import cn.water.project.dao.ProductDao;
import cn.water.project.domain.Product;
import cn.water.project.domain.UserInfo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/1 - 13:13
 * @description
 */
@Service
@Transactional
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductDao productDao;

    /** 查询所有产品信息（展示） */
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    /** 查询所有产品信息（展示），并分页 */
    public List<Product> findAllByPage(int pageNum, int pageSize) throws Exception {
        /* PageHelper：pageNum表示页码值，pageSize表示每页显示数。 */
        PageHelper.startPage(pageNum,pageSize);/* 此行代码必须使用于调用具体MySQL数据库操作语句之前 */
        return productDao.findAll();
    }

    /** 添加新产品（添加） */
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

}
