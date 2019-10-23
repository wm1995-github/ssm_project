package com.wangmin.service;

import com.wangmin.domain.Orders;

import java.util.List;

/**
 * 订单的service 接口
 */
public interface IOrdersService {
    //查询所有订单
    List<Orders> findAll(int page,int size) throws Exception;

    //根据id查询订单详情
    Orders findByOrdersId(String ordersId);
}
