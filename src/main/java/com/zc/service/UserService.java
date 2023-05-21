package com.zc.service;

import com.zc.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zc
 * @since 2023-04-10
 */

@Transactional
public interface UserService {

    User loginUser(Integer id, String password);

    public boolean insert(User user);

    public User selectById(Long id);

    public boolean deleteById(Long id);

    public boolean updateById(User user);

    List<User> selectByUserName(String name);

    List<User> getAll();
}
