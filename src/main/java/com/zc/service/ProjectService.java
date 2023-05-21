package com.zc.service;

import com.zc.domain.Pj;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zc
 * @since 2023-04-12
 */
@Transactional
public interface ProjectService {
    Pj selectById(Long id);

    List<Pj> selectByHeadId(String head_id);

    List<Pj> selectByHeadIdAndSc(String head_id);

    boolean updateByPrimaryKeySelective(Pj pj);

    boolean deleteByPrimaryKey(Long id);

    boolean insert(Pj project);

    Pj selectByNumber(String number);

    List<Pj> selectAll();

    List<Pj> selectByPjName(String name);

    List<Pj> selectByPjNameSh(String name);

    List<Pj> selectAllLx();
}
