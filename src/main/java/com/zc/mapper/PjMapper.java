package com.zc.mapper;

import com.zc.domain.Pj;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZC
 * @description 针对表【tb_pj(项目信息表)】的数据库操作Mapper
 * @createDate 2023-04-13 21:07:40
 * @Entity com.zc.domain.Pj
 */
@Mapper
public interface PjMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Pj record);

    int insertSelective(Pj record);

    Pj selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Pj record);

    int updateByPrimaryKey(Pj record);

    List<Pj> selectByUserid(String pjUserid);

    List<Pj> selectByUseridAndSc(String headId);

    Pj selectByPjNumber(String number);

    List<Pj> selectAll();

    List<Pj> selectByPjName(String name);

    List<Pj> selectByPjNameSh(String name);

    List<Pj> selectAllLx();

    Pj selectByPjId(Integer pjId);

    List<Pj> selectByXy(String userXy);
}
