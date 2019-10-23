package com.wangmin.dao;

import com.wangmin.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 旅客的dao接口
 */
@Repository
public interface ITravellerDao {

//    根据订单的id 查询 旅客的信息
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    List<Traveller> findByOrdersId(String ordersId);
}
