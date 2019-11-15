package cn.water.project.dao;

import cn.water.project.domain.Traveller;
import org.apache.ibatis.annotations.Select;

/**
 * @author Water
 * @date 2019/11/3 - 16:24
 * @description
 */
public interface TravellerDao {

    /** 1、根据orderId查询order_traveller表，获取travellerId */
    /** 2、根据travellerId查询traveller表，获取traveller信息 */
    @Select("SELECT * FROM traveller WHERE id in (SELECT travellerId FROM order_traveller WHERE orderId = #{orderId}) ")
    Traveller findByOrderId(String orderId) throws Exception;


}
