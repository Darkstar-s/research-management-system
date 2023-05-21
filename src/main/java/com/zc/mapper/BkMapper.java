package com.zc.mapper;

import com.zc.domain.Bk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ZC
* @description 针对表【tb_bk(记账员信息表)】的数据库操作Mapper
* @createDate 2023-04-15 11:52:27
* @Entity com.zc.domain.Bk
*/

@Mapper
public interface BkMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Bk record);

    int insertSelective(Bk record);

    Bk selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bk record);

    int updateByPrimaryKey(Bk record);

    List<Bk> selectByBkName(String name);
    Bk loginBk(Integer bkId,String bkPwd);

    List<Bk> getAll();
}
