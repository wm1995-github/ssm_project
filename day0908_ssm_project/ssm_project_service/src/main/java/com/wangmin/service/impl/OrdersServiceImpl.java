package com.wangmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.wangmin.dao.IOrdersDao;
import com.wangmin.domain.Orders;
import com.wangmin.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单的service接口实现类
 */
@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //page是页码值 size是代表每页显示条数
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findByOrdersId(String ordersId) {
        return ordersDao.findByOrdersId(ordersId);

    }
}
