package com.wangmin.service;

import com.wangmin.domain.Role;
import com.wangmin.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * 用户的service层接口
 */
public interface IUserService extends UserDetailsService{
    //查询所有用户
    List<UserInfo> findAll()throws Exception;

    //保存用户
    public void save(UserInfo userInfo) throws Exception;

    //根据指定id查询用户详情
    UserInfo findById(String id)throws Exception;

    //根据用户id查询可以添加的角色
    List<Role> findOtherRoles(String userId) throws Exception;

    //给用户添加角色
    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
