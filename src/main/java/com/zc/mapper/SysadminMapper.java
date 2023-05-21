package com.zc.mapper;

import com.zc.domain.Bk;
import com.zc.domain.Sysadmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ZC
* @description 针对表【tb_sysadmin(超级管理员信息表)】的数据库操作Mapper
* @createDate 2023-04-15 11:52:31
* @Entity com.zc.domain.Sysadmin
*/

@Mapper
public interface SysadminMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Sysadmin record);

    int insertSelective(Sysadmin record);

    Sysadmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sysadmin record);

    int updateByPrimaryKey(Sysadmin record);

    Sysadmin loginSysadmin(Integer sysadminId,String sysadminPwd);

    List<Bk> getAll();


}
