package com.gwf.aop;

import com.gwf.annotation.Log;
import com.gwf.entity.SysLog;
import com.gwf.entity.SysUser;
import com.gwf.service.ILogService;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by gaowenfeng on 2017/3/31.
 */
@Aspect
@Component
public class LoginAop {
    @Autowired
    ILogService iLogService;
    @Autowired
    HttpServletRequest request;

    Logger logger = Logger.getLogger(LoginAop.class);


    @Pointcut("@annotation(com.gwf.annotation.Log)")
    public void annotationPointCut() {
    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        try {
            logger.info("开始aop注解功能");
            Boolean temp = (Boolean)request.getSession().getAttribute("isLogin")==null?false: (Boolean)request.getSession().getAttribute("isLogin");
            if(temp) {
                Object principal = SecurityContextHolder.getContext()
                        .getAuthentication().getPrincipal();
                SysUser sysUser = new SysUser();
                if (principal instanceof UserDetails) {
                    sysUser = (SysUser) principal;
                }
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
                Method method = signature.getMethod();
                Log log = method.getAnnotation(Log.class);
                SysLog sysLog = new SysLog();
                StringBuilder sb = new StringBuilder();
                if (sysUser != null) {
                    String ip = iLogService.getIp(request);
                    sb.append("用户").append(sysUser.getUsername()).append("使用ip:").append(ip).append("进行了登录");
                    sysLog.setContent(sb.toString());
                    sysLog.setCreatedate(new Date());
                    sysLog.setUserid(sysUser.getId());
                    sysLog.setOperation(log.name());
                    iLogService.saveLog(sysLog);
                    request.getSession().removeAttribute("isLogin");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("aop出现异常");
        }
        finally {
            logger.info("aop结束");
        }
    }
}
