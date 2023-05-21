package com.zc.service.impl;

import com.zc.domain.Bfd;
import com.zc.mapper.BfdMapper;
import com.zc.service.BfdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BfdServiceImpl implements BfdService {

    @Autowired
    private BfdMapper bfdMapper;

    @Override
    public boolean insert(Bfd bfd) {
        return bfdMapper.insert(bfd) > 0;
    }

    @Override
    public List<Bfd> selectByNumber(String number) {
        return bfdMapper.selectByNumber(number);
    }

    @Override
    public List<Bfd> selectAll() {
        return bfdMapper.selectAll();
    }

    @Override
    public Bfd getById(Long id) {
        return bfdMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Bfd bfd) {
        return bfdMapper.updateByPrimaryKeySelective(bfd) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return bfdMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Bfd> selectByUserid(Long userId) {
        return bfdMapper.selectByUserid(userId);
    }
}
