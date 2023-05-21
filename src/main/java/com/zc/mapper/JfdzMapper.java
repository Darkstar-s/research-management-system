package com.zc.mapper;

import com.zc.domain.Jfdz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZC
 * @description 针对表【tb_jfdz】的数据库操作Mapper
 * @createDate 2023-04-19 21:14:26
 * @Entity com.zc.domain.Jfdz
 */

@Mapper
public interface JfdzMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Jfdz record);

    int insertSelective(Jfdz record);

    Jfdz selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Jfdz record);

    int updateByPrimaryKey(Jfdz record);

    List<Jfdz> selectAll();

    List<Jfdz> selectByXmNumber(String name);

    List<Jfdz> selectByUserid(Long userId);
}
