package com.zc.service;

import com.zc.domain.Bfd;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BfdService {
    boolean insert(Bfd bfd);
    List<Bfd> selectByNumber(String number);

    List<Bfd> selectAll();

    Bfd getById(Long id);

    boolean update(Bfd bfd);

    boolean delete(Long id);

    List<Bfd> selectByUserid(Long userId);
}
