package com.wangmin.service;

import com.wangmin.domain.Product;

import java.util.List;

/**
 * 产品的service接口
 */
public interface IProductService {

    //查询产品的所有信息
    List<Product> findAll() throws Exception;

    //添加产品
    void save(Product product);
}
