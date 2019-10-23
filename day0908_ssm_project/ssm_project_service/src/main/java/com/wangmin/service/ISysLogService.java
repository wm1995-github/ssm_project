package com.wangmin.service;

import com.wangmin.domain.SysLog;

import java.util.List;

/**
 * 日志的service接口
 */
public interface ISysLogService {
    //保存日志
    public void save(SysLog sysLog)throws Exception;

    //查询所有日志
    List<SysLog> findAll() throws Exception;
}
