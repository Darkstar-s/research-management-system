package com.zc.service;

import com.zc.domain.Jfdz;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface JfdzService {
    List<Jfdz> selectAll();

    List<Jfdz> selectByNumber(String name);

    boolean insert(Jfdz jfdz);

    boolean update(Jfdz jfdz);

    Jfdz selectById(Long id);

    boolean deleteById(Long id);

    List<Jfdz> selectByUserid(String id);
}
