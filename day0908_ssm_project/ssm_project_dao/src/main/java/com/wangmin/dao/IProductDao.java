package com.wangmin.dao;

import com.wangmin.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品的dao接口
 */
@Repository
public interface IProductDao {


    //查询产品的所有信息
    @Select("select * from PRODUCT")
    List<Product> findAll() throws Exception;


    //添加产品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);


    //根据id查询产品
    @Select("select * from product where id = #{id}")
    public Product findById(String id)throws Exception;
}
