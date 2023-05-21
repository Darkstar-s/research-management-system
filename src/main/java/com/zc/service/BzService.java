package com.zc.service;

import com.zc.domain.Bz;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author ZC
* @description 针对表【tb_bz】的数据库操作Service
* @createDate 2023-04-18 12:19:40
*/
@Transactional
public interface BzService {

    List<Bz> selectByName(String name);

    boolean insert(Bz bz);

    boolean update(Bz bz);

    List<Bz> getAll();

    Bz getById(String id);

    boolean delete(Long id);

    List<Bz> selectByUserid(Long userId);
}
