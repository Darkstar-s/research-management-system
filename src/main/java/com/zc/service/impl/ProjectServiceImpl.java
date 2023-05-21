package com.zc.service.impl;

import com.zc.domain.Pj;
import com.zc.mapper.PjMapper;
import com.zc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zc
 * @since 2023-04-12
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private PjMapper pjMapper;

    @Override
    public Pj selectById(Long id) {
        return pjMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pj> selectByHeadId(String headId) {
        return pjMapper.selectByUserid(headId);
    }

    @Override
    public List<Pj> selectByHeadIdAndSc(String headId) {
        return pjMapper.selectByUseridAndSc(headId);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Pj Pj) {
        return pjMapper.updateByPrimaryKeySelective(Pj) > 0;
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return pjMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean insert(Pj pj) {
        return pjMapper.insertSelective(pj) > 0;
    }

    @Override
    public Pj selectByNumber(String number) {
        return pjMapper.selectByPjNumber(number);
    }

    @Override
    public List<Pj> selectAll() {
        return pjMapper.selectAll();
    }

    @Override
    public List<Pj> selectByPjName(String name) {
        return pjMapper.selectByPjName(name);
    }

    @Override
    public List<Pj> selectByPjNameSh(String name) {
        return pjMapper.selectByPjNameSh(name);
    }

    @Override
    public List<Pj> selectAllLx() {
        return pjMapper.selectAllLx();
    }
}
