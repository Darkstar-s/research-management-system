package com.zc.controller;


import com.zc.controller.other.Code;
import com.zc.controller.other.Result;
import com.zc.domain.*;
import com.zc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zc
 * @since 2023-04-12
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private JfdzService jfdzService;

    @Autowired
    private BfdService bfdService;

    @Autowired
    private BzService bzService;

    @GetMapping("/getProject")
    public Result selectById(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("UserSession");
        String id = String.valueOf(user.getUserId());
        List<Pj> projects = projectService.selectByHeadId(id);

//        System.out.println(projects);

        Integer code = projects != null ? Code.GET_OK : Code.GET_ERR;
        String msg = projects != null ? "" : "数据查询失败，请重试！";
        return new Result(code, projects, msg);
    }

    @GetMapping("/getProject1")
    public Result selectByIdAndSc(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("UserSession");
        String id = String.valueOf(user.getUserId());
        List<Pj> projects = projectService.selectByHeadIdAndSc(id);

//        System.out.println(projects);

        Integer code = projects != null ? Code.GET_OK : Code.GET_ERR;
        String msg = projects != null ? "" : "数据查询失败，请重试！";
        return new Result(code, projects, msg);
    }

    @GetMapping("/getOneProject" + "/{pjId}")
    public Result selectByXmId(@PathVariable String pjId) {
        Pj project = projectService.selectById(Long.valueOf(pjId));
      /*  System.out.println("----------------------------------------------------------");
        System.out.println(project);*/
        Integer code = project != null ? Code.GET_OK : Code.GET_ERR;
        String msg = project != null ? "" : "数据查询失败，请重试！";
        return new Result(code, project, msg);
    }

    @GetMapping("/getOneProject1" + "/{pjId}")
    public Result selectByXmId1(@PathVariable String pjId) {
        Pj project = projectService.selectById(Long.valueOf(pjId));
        if (project != null) {
            if (project.getPjJtstatus().equals("1") || project.getPjJtstatus().equals("2")) {
                return new Result(1, "", "当前状态不可修改！");
            }
            return new Result(Code.GET_OK, project, "");
        }
        return new Result(Code.GET_ERR, "数据查询失败，请重试！");
        /*Integer code = project != null ? Code.GET_OK : Code.GET_ERR;
        String msg = project != null ? "" : "数据查询失败，请重试！";
        return new Result(code, project, msg);*/
    }

    @PutMapping("/update")
    public Result updateById(@RequestBody Pj project) {
        int i = Integer.parseInt(project.getPjShstatus());
        if (i != 1) {
            boolean flag = projectService.updateByPrimaryKeySelective(project);
            return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
        }
        return new Result("当前状态不可修改!");

    }

    @PutMapping("/update1")
    public Result updateById1(@RequestBody Pj project) {
        int i = Integer.parseInt(project.getPjBcstatus());
        if (i != 1) {
            boolean flag = projectService.updateByPrimaryKeySelective(project);
            return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
        }
        return new Result("当前状态不可修改!");
    }

    @PutMapping("/update2")
    public Result updateById2(@RequestBody Pj project) {
        boolean flag = projectService.updateByPrimaryKeySelective(project);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/delete" + "/{pjId}")
    public Result deleteById(@PathVariable String pjId) {
        int i = Integer.parseInt(projectService.selectById(Long.valueOf(pjId)).getPjShstatus());
        if (i != 1) {
            boolean flag = projectService.deleteByPrimaryKey(Long.valueOf(pjId));
            return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
        }
        return new Result("当前状态不可删除!");
    }

    @GetMapping("/getHt" + "/{xmId}")
    public Result getHtById(@PathVariable String xmId) {
        Pj project = projectService.selectById(Long.valueOf(xmId));
        Integer code = project != null ? Code.GET_OK : Code.GET_ERR;
        String msg = project != null ? "" : "数据查询失败，请重试！";
        return new Result(code, project, msg);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Pj project, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("UserSession");
        project.setPjUser(user.getUserName());
        project.setPjUserid(String.valueOf(user.getUserId()));
        boolean flag = projectService.insert(project);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @GetMapping("/getDzd")
    public Result getDzd(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("UserSession");
        Integer userId = user.getUserId();
        List<Jfdz> jfdzs = jfdzService.selectByUserid(String.valueOf(userId));
        Integer code = jfdzs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = jfdzs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, jfdzs, msg);
    }

    @GetMapping("/getBfd")
    public Result getBfd(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("UserSession");
        Integer userId = user.getUserId();
        List<Bfd> bfds = bfdService.selectByUserid(Long.valueOf(userId));
        Integer code = bfds != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bfds != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bfds, msg);
    }

    @GetMapping("/getBz")
    public Result getBz(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("UserSession");
        Integer userId = user.getUserId();
        List<Bz> bzs = bzService.selectByUserid(Long.valueOf(userId));
        Integer code = bzs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bzs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bzs, msg);
    }

    @GetMapping("/getDzdByName")
    public Result getDzdByName(@RequestParam String searchName) {
        List<Jfdz> jfdzs = jfdzService.selectByNumber(searchName);
        Integer code = jfdzs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = jfdzs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, jfdzs, msg);
    }

    @PostMapping("/insertJfdz")
    public Result insertJfdz(@RequestBody Jfdz jfdz) {
        Pj pj = projectService.selectByNumber(jfdz.getXmNumber());
        if (pj == null) {
            return new Result("不存在此编号，请重新输入");
        }
        boolean flag = jfdzService.insert(jfdz);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @PostMapping("/insertBfd")
    public Result insertBfd(@RequestBody Bfd bfd) {
        Pj pj = projectService.selectByNumber(bfd.getPjNumber());
        if (pj == null) {
            return new Result("不存在此编号，请重新输入");
        }
        boolean flag = bfdService.insert(bfd);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @GetMapping("/getBfdByName")
    public Result getBfdByName(@RequestParam String searchName) {
        List<Bfd> bfds = bfdService.selectByNumber(searchName);
        Integer code = bfds != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bfds != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bfds, msg);
    }

    @GetMapping("/getBzByName")
    public Result getBzByName(@RequestParam String searchName) {
        List<Bz> bzs = bzService.selectByName(searchName);
        Integer code = bzs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bzs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bzs, msg);
    }

    @PostMapping("/insertBz")
    public Result insertBz(@RequestBody Bz bz) {
        Pj pj = projectService.selectByNumber(bz.getPjName());
        if (pj == null) {
            return new Result("不存在此编号，请重新输入");
        }
        boolean flag = bzService.insert(bz);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @GetMapping("/getMyself")
    public Result getMyself(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("UserSession");
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败，请重试！";
        return new Result(code, user, msg);
    }

    @PostMapping("/updatePwd")
    public Result updatePwd(HttpServletRequest request, @RequestBody PasswordRequest passwordRequest) {

        User user = (User) request.getSession().getAttribute("UserSession");
        if (passwordRequest.getOldPassword().equals(user.getUserPwd())) {
            user.setUserPwd(passwordRequest.getNewPassword());
            boolean flag = userService.updateById(user);
            return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
        }
        return new Result("更改出现错误，请稍后重试！");
    }
}

