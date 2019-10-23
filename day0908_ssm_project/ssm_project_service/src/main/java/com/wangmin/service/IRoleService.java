package com.wangmin.service;

import com.wangmin.domain.Permission;
import com.wangmin.domain.Role;

import java.util.List;

/**
 * 角色的service接口
 */
public interface IRoleService {

    //查询所有角色
    List<Role> findAll()throws Exception;

    //保存角色
    void save(Role role)throws Exception;

    //根据id查询角色
    Role findById(String roleId) throws Exception;

    //查询角色可以添加的权限
    List<Permission> findOtherPermission(String roleId) throws Exception;

    //给角色添加权限
    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
