package com.gwf.service;

import com.gwf.entity.SysLog;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gaowenfeng on 2017/3/31.
 */
public interface ILogService {
    String getIp(HttpServletRequest request);

    void saveLog(SysLog sysLog);
}
