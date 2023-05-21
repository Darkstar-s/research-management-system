package com.zc.mapper;

import com.zc.domain.User;
import com.zc.domain.XySum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author ZC
* @description 针对表【tb_user(用户信息表)】的数据库操作Mapper
* @createDate 2023-04-13 21:07:31
* @Entity com.zc.domain.User
*/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByUserName(String name);

    User selectByIdAndPassword(Integer userId, String userPwd);

    List<User> selectAll();

    @Select("SELECT\n" +
            "    tb_user.user_xy AS college,\n" +
            "    YEAR(tb_jfdz.dz_time) AS year,\n" +
            "    SUM(tb_jfdz.dz_money) AS fundingAmount\n" +
            "FROM\n" +
            "    tb_pj\n" +
            "    INNER JOIN tb_jfdz ON tb_pj.pj_number = tb_jfdz.xm_number\n" +
            "    INNER JOIN tb_user ON tb_pj.pj_userid = tb_user.user_id\n" +
            "\n" +
            "where (dz_status = 1)\n" +
            "\n" +
            "GROUP BY\n" +
            "    tb_user.user_xy, YEAR(tb_jfdz.dz_time)")
    @Results({
            @Result(property = "college", column = "college"),
            @Result(property = "year", column = "year"),
            @Result(property = "fundingAmount", column = "fundingAmount")
    })
    List<XySum> selectByXy();
}
