package com.zc.mapper;

import com.zc.domain.Bz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ZC
* @description 针对表【tb_bz】的数据库操作Mapper
* @createDate 2023-04-19 23:07:58
* @Entity com.zc.domain.Bz
*/

@Mapper
public interface BzMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Bz record);

    int insertSelective(Bz record);

    Bz selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bz record);

    int updateByPrimaryKey(Bz record);

    List<Bz> selectByName(String pjName);

    List<Bz> selectAll();

    List<Bz> selectByUserid(Long userId);

}
