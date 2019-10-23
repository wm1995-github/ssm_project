package com.wangmin.service.impl;

import com.wangmin.dao.IRoleDao;
import com.wangmin.domain.Permission;
import com.wangmin.domain.Role;
import com.wangmin.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    //查询所有角色
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    //保存角色
    @Override
    public void save(Role role) throws Exception{
        roleDao.save(role);
    }

    //根据id查询角色
    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    //查询角色可以添加的权限
    @Override
    public List<Permission> findOtherPermission(String roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    //给角色添加权限
    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
