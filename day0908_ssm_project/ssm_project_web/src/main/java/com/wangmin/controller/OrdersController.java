package com.wangmin.controller;

import com.github.pagehelper.PageInfo;
import com.wangmin.domain.Orders;
import com.wangmin.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    //查询所有订单方法
    @RequestMapping("/findAll")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue ="1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,size);

    /*    for (Orders orders : ordersList) {
            System.out.println(orders);
        }*/

        //PageInfo就是一个分页bean
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    //查询订单详情法
    @RequestMapping("/findByOrdersId")
    public ModelAndView findByOrdersId(@RequestParam(name = "ordersId")String ordersId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findByOrdersId(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
