package com.wangmin.controller;

import com.wangmin.domain.Product;
import com.wangmin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();

        for (Product product : products) {
            String str = product.getProductStatusStr();
            System.out.println(str);
        }

        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }

    //产品添加方法
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll";
    }


}
