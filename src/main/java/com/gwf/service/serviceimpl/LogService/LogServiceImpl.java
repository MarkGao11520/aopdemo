package com.gwf.service.serviceimpl.LogService;

import com.gwf.dao.SysLogRepository;
import com.gwf.entity.SysLog;
import com.gwf.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gaowenfeng on 2017/3/31.
 */
@Service
public class LogServiceImpl implements ILogService{
    @Autowired
    SysLogRepository sysLogRepository;

    /**
     * 获取ip
     * @param request
     * @return
     */
    @Override
    public String getIp(HttpServletRequest request) {
        // TODO Auto-generated method stub
        try {
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))  {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            return ip;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveLog(SysLog sysLog) {
        sysLogRepository.save(sysLog);
    }
}
