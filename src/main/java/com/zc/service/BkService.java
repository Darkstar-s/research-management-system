package com.zc.service;

import com.zc.domain.Bk;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BkService {
    Bk loginBk(Integer id, String password);

    boolean update(Bk bk);

    boolean insert(Bk bk);

    boolean delete(Long id);

    List<Bk> getAll();

    Bk getById(Long id);

    List<Bk> getByName(String name);
}
