package cn.water.project.dao;

import cn.water.project.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Water
 * @date 2019/11/1 - 13:13
 * @description
 */
public interface ProductDao {

    /** 根据id，查询产品信息 */
    @Select("SELECT * FROM product WHERE id = #{productId}")
    Product findById(String productId) throws Exception;

    /** 查询所有产品信息（展示） */
    @Select("SELECT * FROM product")
    List<Product> findAll() throws Exception;

    /** 添加新产品（添加） */
    @Insert("INSERT INTO product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "VALUES(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

}
