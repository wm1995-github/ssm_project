package com.wangmin.service.impl;

import com.wangmin.dao.IProductDao;
import com.wangmin.domain.Product;
import com.wangmin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IProductService 接口的实现
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;


    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }
}
