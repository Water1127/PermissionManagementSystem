package cn.water.project.service;


import cn.water.project.domain.Product;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/1 - 13:13
 * @description
 */
public interface ProductService {

    /** 查询所有产品信息（展示） */
    List<Product> findAll () throws Exception;

    /** 查询所有产品信息（展示），并分页 */
    List<Product> findAllByPage (int pageNum, int pageSize) throws Exception;

    /** 添加新产品（添加） */
    void save(Product product) throws Exception;

}
