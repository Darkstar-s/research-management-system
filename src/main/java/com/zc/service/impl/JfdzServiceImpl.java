package com.zc.service.impl;

import com.zc.domain.Jfdz;
import com.zc.mapper.JfdzMapper;
import com.zc.service.JfdzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JfdzServiceImpl implements JfdzService {

    @Autowired
    private JfdzMapper jfdzMapper;

    @Override
    public List<Jfdz> selectAll() {
        return jfdzMapper.selectAll();
    }

    @Override
    public List<Jfdz> selectByNumber(String name) {
        return jfdzMapper.selectByXmNumber(name);
    }

    @Override
    public boolean insert(Jfdz jfdz) {
        return jfdzMapper.insertSelective(jfdz) > 0;
    }

    @Override
    public boolean update(Jfdz jfdz) {
        return jfdzMapper.updateByPrimaryKeySelective(jfdz) > 0;
    }

    @Override
    public Jfdz selectById(Long id) {
        return jfdzMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteById(Long id) {
        return jfdzMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Jfdz> selectByUserid(String id) {
        return jfdzMapper.selectByUserid(Long.valueOf(id));
    }
}
