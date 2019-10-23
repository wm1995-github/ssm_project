package com.wangmin.dao;

import com.wangmin.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限的 dao接口
 */
@Repository
public interface IPermissionDao {
    /**
     * 根据角色Id 查询 角色拥有的权限
     */
    @Select("select * from PERMISSION where id in (select PERMISSIONID from ROLE_PERMISSION where ROLEID = #{roleId})")
    public List<Permission> findPermissionByRoleId(String roleId);

    //查询所有权限
    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    //保存权限
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
