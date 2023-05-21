package com.zc.service;

import com.zc.domain.Admin;
import com.zc.domain.XySum;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface AdminService {
    Admin loginAdmin(Integer id,String password);

    boolean updateById(Admin admin);

    List<Admin> getAll();

    Admin getById(Long id);

    boolean delete(Long id);

    List<Admin> getByName(String name);

    boolean insert(Admin admin);

    List<XySum> getByXy();
}
