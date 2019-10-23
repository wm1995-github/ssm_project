package com.wangmin.service.impl;

import com.wangmin.dao.ISysLogDao;
import com.wangmin.domain.SysLog;
import com.wangmin.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 记录日志的service实现类
 */
@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;

    //保存日志
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    //查询所有日志
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
