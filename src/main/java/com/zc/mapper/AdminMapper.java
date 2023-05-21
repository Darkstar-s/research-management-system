package com.zc.mapper;

import com.zc.domain.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author ZC
 * @description 针对表【tb_admin(学校管理员信息表)】的数据库操作Mapper
 * @createDate 2023-04-19 13:16:17
 * @Entity com.zc.domain.Admin
 */
@Mapper
public interface AdminMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectByAdminName(String name);
    Admin LoginAdmin(Integer adminId, String adminPwd);

    List<Admin> selectAll();

}
