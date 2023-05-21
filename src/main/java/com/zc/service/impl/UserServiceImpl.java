package com.zc.service.impl;

import com.zc.domain.User;
import com.zc.mapper.UserMapper;
import com.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zc
 * @since 2023-04-10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginUser(Integer id, String password) {
        return userMapper.selectByIdAndPassword(id, password);
    }

    @Override
    public boolean insert(User user) {
        return userMapper.insertSelective(user) > 0;
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteById(Long id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean updateById(User user) {
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    @Override
    public List<User> selectByUserName(String name) {
        return userMapper.selectByUserName(name);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }
}
