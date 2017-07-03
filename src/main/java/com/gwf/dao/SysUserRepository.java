package com.gwf.dao;

import com.gwf.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gaowenfeng on 2017/3/31.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long>{
    SysUser findByUsername(String username);
}
