package com.zc.service;

import com.zc.domain.Sysadmin;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SysadminService {
    Sysadmin loginSysadmin(Integer id, String password);

    boolean update(Sysadmin sysadmin);
}
