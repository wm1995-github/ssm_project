package com.wangmin.dao;

import com.wangmin.domain.Permission;
import com.wangmin.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *  角色的 dao 接口
 */
@Repository
public interface IRoleDao {
    //根据用户的id 查询所有对应的角色
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.wangmin.dao.IPermissionDao.findPermissionByRoleId"))
    })

    List<Role> findRoleByUserId(String userId) throws Exception;

    //查询所有角色
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    //保存角色
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    //根据id查询角色
    @Select("select * from role where id = #{roleId}")
    Role findById(String roleId)throws Exception;

    //查询角色可以添加的权限
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findOtherPermission(String roleId);

    //给角色添加权限
    @Insert("insert into role_permission(roleId,permissionId) values (#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId)throws Exception;
}
