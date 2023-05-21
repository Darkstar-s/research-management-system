package com.zc.service.impl;

import com.zc.domain.Bk;
import com.zc.mapper.BkMapper;
import com.zc.service.BkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BkServiceImpl implements BkService {

    @Autowired
    private BkMapper bkMapper;

    @Override
    public Bk loginBk(Integer id, String password) {
        return bkMapper.loginBk(id, password);
    }

    @Override
    public boolean update(Bk bk) {
        return bkMapper.updateByPrimaryKeySelective(bk) > 0;
    }

    @Override
    public boolean insert(Bk bk) {
        return bkMapper.insertSelective(bk) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return bkMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Bk> getAll() {
        return bkMapper.getAll();
    }

    @Override
    public Bk getById(Long id) {
        return bkMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Bk> getByName(String name) {
        return bkMapper.selectByBkName(name);
    }
}
