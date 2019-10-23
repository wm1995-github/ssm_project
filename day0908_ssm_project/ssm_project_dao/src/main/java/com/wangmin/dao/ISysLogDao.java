package com.wangmin.dao;

import com.wangmin.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 记录日志的dao接口
 */
@Repository
public interface ISysLogDao {
    //保存日志
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog)throws Exception;

    //查询所有日志
    @Select("select * from syslog")
    List<SysLog> findAll() throws Exception;
}
