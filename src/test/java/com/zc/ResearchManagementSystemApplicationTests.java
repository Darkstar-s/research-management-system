package com.zc;

import com.zc.domain.Admin;
import com.zc.domain.Jfdz;
import com.zc.domain.Pj;
import com.zc.domain.XySum;
import com.zc.mapper.AdminMapper;
import com.zc.mapper.JfdzMapper;
import com.zc.mapper.PjMapper;
import com.zc.mapper.UserMapper;
import com.zc.service.ProjectService;
import com.zc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ResearchManagementSystemApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private PjMapper pjMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JfdzMapper jfdzMapper;

    @Test
    public void test() {
        List<Jfdz> jfdzs = jfdzMapper.selectByUserid(2019125L);
        System.out.println(jfdzs);
    }
}
