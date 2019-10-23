package com.wangmin.service;

import com.wangmin.domain.Permission;

import java.util.List;

/**
 * 权限的service接口
 */

public interface IPermissionService {
    //查询所有权限
    List<Permission> findAll()throws Exception;

    void save(Permission permission) throws Exception;
}
