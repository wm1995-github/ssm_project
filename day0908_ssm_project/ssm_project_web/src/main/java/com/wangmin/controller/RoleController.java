package com.wangmin.controller;

import com.wangmin.domain.Permission;
import com.wangmin.domain.Role;
import com.wangmin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    //查询所有角色
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    //添加角色
    @RequestMapping("/save")
    public String save(Role role)throws Exception{
        roleService.save(role);
        return "redirect:findAll";
    }

    //根据roleId查询role，并查询出可以添加的权限
    @RequestMapping("/findRoleByIdAndAllPermission")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId)throws Exception{
        //1.根据id查询角色
        Role role = roleService.findById(roleId);
        //2.查询角色可以添加的权限
        List<Permission> otherPermission = roleService.findOtherPermission(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermission);
        mv.setViewName("role-permission-add");
        return mv;
    }

    //给角色添加权限
    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String[] permissionIds)throws Exception{
        roleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll";
    }
}
