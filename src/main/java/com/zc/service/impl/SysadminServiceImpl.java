package com.zc.service.impl;

import com.zc.domain.Sysadmin;
import com.zc.mapper.SysadminMapper;
import com.zc.service.SysadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysadminServiceImpl implements SysadminService {

    @Autowired
    private SysadminMapper sysadminMapper;

    @Override
    public Sysadmin loginSysadmin(Integer id, String password) {
        return sysadminMapper.loginSysadmin(id, password);
    }

    @Override
    public boolean update(Sysadmin sysadmin) {
        return sysadminMapper.updateByPrimaryKeySelective(sysadmin) > 0;
    }
}
