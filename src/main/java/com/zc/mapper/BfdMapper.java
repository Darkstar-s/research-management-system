package com.zc.mapper;

import com.zc.domain.Bfd;
import com.zc.domain.Jfdz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ZC
* @description 针对表【tb_bfd】的数据库操作Mapper
* @createDate 2023-04-19 21:35:00
* @Entity com.zc.domain.Bfd
*/

@Mapper
public interface BfdMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Bfd record);

    int insertSelective(Bfd record);

    Bfd selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bfd record);

    int updateByPrimaryKey(Bfd record);

    List<Bfd> selectByNumber(String number);

    List<Bfd> selectAll();

    List<Bfd> selectByUserid(Long userId);

}
