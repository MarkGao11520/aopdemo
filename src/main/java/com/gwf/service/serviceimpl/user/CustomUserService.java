package com.gwf.service.serviceimpl.user;

import com.gwf.annotation.Log;
import com.gwf.dao.SysUserRepository;
import com.gwf.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by gaowenfeng on 2017/3/31.
 */
public class CustomUserService implements UserDetailsService{
    @Autowired
    SysUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    HttpServletRequest request;
    @Override
//    @Log(name = "登录")
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser =userRepository.findByUsername(s);
        if(sysUser == null){
            throw  new UsernameNotFoundException("用户名不存在");
        }
        String password = passwordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(password);
        request.getSession().setAttribute("isLogin",true);
        return sysUser;
    }


}
