package com.wangmin.dao;

import com.wangmin.domain.Member;
import com.wangmin.domain.Orders;
import com.wangmin.domain.Product;
import com.wangmin.domain.Traveller;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单的dao接口
 */
@Repository
public interface IOrdersDao {

    //查询所有订单
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",javaType = Product.class,one = @One(select = "com.wangmin.dao.IProductDao.findById",fetchType = FetchType.DEFAULT))
    })
    List<Orders> findAll() throws Exception;

    //查询订单详情
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",javaType = Product.class,one = @One(select = "com.wangmin.dao.IProductDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "member",column = "memberid",javaType = Member.class,one = @One(select = "com.wangmin.dao.IMemberDao.findById",fetchType = FetchType.EAGER)),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class, many = @Many(select = "com.wangmin.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findByOrdersId(String ordersId);
}
