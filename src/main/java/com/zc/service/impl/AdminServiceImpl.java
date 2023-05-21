package com.zc.service.impl;

import com.zc.domain.Admin;
import com.zc.domain.XySum;
import com.zc.mapper.AdminMapper;
import com.zc.mapper.UserMapper;
import com.zc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Admin loginAdmin(Integer id, String password) {
        return adminMapper.LoginAdmin(id, password);
    }

    @Override
    public boolean updateById(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin) > 0;
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectAll();
    }

    @Override
    public Admin getById(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean delete(Long id) {
        return adminMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Admin> getByName(String name) {
        return adminMapper.selectByAdminName(name);
    }

    @Override
    public boolean insert(Admin admin) {
        return adminMapper.insertSelective(admin) > 0;
    }

    @Override
    public List<XySum> getByXy() {
        return userMapper.selectByXy();
    }
}
