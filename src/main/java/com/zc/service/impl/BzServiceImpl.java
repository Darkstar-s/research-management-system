package com.zc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.domain.Bz;
import com.zc.service.BzService;
import com.zc.mapper.BzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZC
 * @description 针对表【tb_bz】的数据库操作Service实现
 * @createDate 2023-04-18 12:19:40
 */
@Service
public class BzServiceImpl implements BzService {

    @Autowired
    private BzMapper bzMapper;

    @Override
    public List<Bz> selectByName(String name) {
        return bzMapper.selectByName(name);
    }

    @Override
    public boolean insert(Bz bz) {
        return bzMapper.insertSelective(bz) > 0;
    }

    @Override
    public boolean update(Bz bz) {
        return bzMapper.updateByPrimaryKeySelective(bz) > 0;
    }

    @Override
    public List<Bz> getAll() {
        return bzMapper.selectAll();
    }

    @Override
    public Bz getById(String id) {
        return bzMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public boolean delete(Long id) {
        return bzMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public List<Bz> selectByUserid(Long userId) {
        return bzMapper.selectByUserid(userId);
    }
}




