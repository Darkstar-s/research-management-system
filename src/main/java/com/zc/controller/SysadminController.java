package com.zc.controller;

import com.zc.controller.other.Code;
import com.zc.controller.other.Result;
import com.zc.domain.*;
import com.zc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/sysadmin")
public class SysadminController {

    @Autowired
    private SysadminService sysadminService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private BkService bkService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private JfdzService jfdzService;

    @Autowired
    private BzService bzService;

    @Autowired
    private BfdService bfdService;

    @PostMapping("/updatePwd")
    public Result updatePwd(HttpServletRequest request, @RequestBody PasswordRequest passwordRequest) {
        Sysadmin sysadmin = (Sysadmin) request.getSession().getAttribute("UserSession");
        if (passwordRequest.getOldPassword().equals(sysadmin.getSysadminPwd())) {
            sysadmin.setSysadminPwd(passwordRequest.getNewPassword());
            boolean flag = sysadminService.update(sysadmin);
            return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
        }
        return new Result("更改出现错误，请稍后重试！");
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Pj pj) {
        boolean flag = projectService.insert(pj);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @PutMapping("/updatePj")
    public Result updatePj(@RequestBody Pj project) {
        boolean flag = projectService.updateByPrimaryKeySelective(project);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/deletePj" + "/{pjId}")
    public Result deletePj(@PathVariable String pjId) {
        boolean flag = projectService.deleteByPrimaryKey(Long.valueOf(pjId));
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/getJfdzById" + "/{dzId}")
    public Result getJfdzById(@PathVariable String dzId) {
        Jfdz jfdz = jfdzService.selectById(Long.valueOf(dzId));
        Integer code = jfdz != null ? Code.GET_OK : Code.GET_ERR;
        String msg = jfdz != null ? "" : "数据查询失败，请重试！";
        return new Result(code, jfdz, msg);
    }

    @PutMapping("/updateJfdz")
    public Result updateJfdz(@RequestBody Jfdz jfdz) {
        boolean flag = jfdzService.update(jfdz);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/deleteJfdz" + "/{dzId}")
    public Result deleteById(@PathVariable String dzId) {
        boolean flag = jfdzService.deleteById(Long.valueOf(dzId));
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @DeleteMapping("/deleteBfd" + "/{id}")
    public Result deleteBfd(@PathVariable String id) {
        boolean flag = bfdService.delete(Long.valueOf(id));
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/getBfdById" + "/{id}")
    public Result getBfdById(@PathVariable String id) {
        Bfd bfd = bfdService.getById(Long.valueOf(id));
        Integer code = bfd != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bfd != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bfd, msg);
    }

    @PutMapping("/updateBfd")
    public Result updateBfd(@RequestBody Bfd bfd) {
        boolean flag = bfdService.update(bfd);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @GetMapping("/getBzById" + "/{id}")
    public Result getBzById(@PathVariable String id) {
        Bz bz = bzService.getById(id);
        Integer code = bz != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bz != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bz, msg);
    }

    @PutMapping("/updateBz")
    public Result updateBz(@RequestBody Bz bz) {
        boolean flag = bzService.update(bz);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/deleteBz" + "/{id}")
    public Result deleteBz(@PathVariable String id) {
        boolean flag = bzService.delete(Long.valueOf(id));
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/getAllAdmin")
    public Result getAllAdmin() {
        List<Admin> admins = adminService.getAll();
        Integer code = admins != null ? Code.GET_OK : Code.GET_ERR;
        String msg = admins != null ? "" : "数据查询失败，请重试！";
        return new Result(code, admins, msg);
    }

    @GetMapping("/getByAdminname")
    public Result getByAdminname(@RequestParam String searchName) {
        List<Admin> admins = adminService.getByName(searchName);
        Integer code = admins != null ? Code.GET_OK : Code.GET_ERR;
        String msg = admins != null ? "" : "数据查询失败，请重试！";
        return new Result(code, admins, msg);
    }

    @PostMapping("/insertAdmin")
    public Result insertAdmin(@RequestBody Admin admin) {
        boolean flag = adminService.insert(admin);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @GetMapping("/getAdmin" + "/{adminId}")
    public Result getAdmin(@PathVariable String adminId) {
        Admin admin = adminService.getById(Long.valueOf(adminId));
        Integer code = admin != null ? Code.GET_OK : Code.GET_ERR;
        String msg = admin != null ? "" : "数据查询失败，请重试！";
        return new Result(code, admin, msg);
    }

    @PutMapping("/updateAdmin")
    public Result updateAdmin(@RequestBody Admin admin) {
        boolean flag = adminService.updateById(admin);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/deleteAdmin" + "/{adminId}")
    public Result deleteAdmin(@PathVariable String adminId) {
        boolean flag = adminService.delete(Long.valueOf(adminId));
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/getAllUser")
    public Result getAllUser() {
        List<User> users = userService.getAll();
        Integer code = users != null ? Code.GET_OK : Code.GET_ERR;
        String msg = users != null ? "" : "数据查询失败，请重试！";
        return new Result(code, users, msg);
    }

    @GetMapping("/getByUsername")
    public Result getBzByName(@RequestParam String searchName) {
        List<User> users = userService.selectByUserName(searchName);
        Integer code = users != null ? Code.GET_OK : Code.GET_ERR;
        String msg = users != null ? "" : "数据查询失败，请重试！";
        return new Result(code, users, msg);
    }

    @PostMapping("/insertUser")
    public Result insertUser(@RequestBody User user) {
        boolean flag = userService.insert(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @GetMapping("/getUser" + "/{userId}")
    public Result getUser(@PathVariable String userId) {
        User user = userService.selectById(Long.valueOf(userId));
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败，请重试！";
        return new Result(code, user, msg);
    }

    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User user) {
        boolean flag = userService.updateById(user);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/deleteUser" + "/{userId}")
    public Result deleteUser(@PathVariable String userId) {
        boolean flag = userService.deleteById(Long.valueOf(userId));
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/getAllBk")
    public Result getAllBk() {
        List<Bk> bks = bkService.getAll();
        Integer code = bks != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bks != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bks, msg);
    }

    @GetMapping("/getByBkname")
    public Result getByBkname(@RequestParam String searchName) {
        List<Bk> bks = bkService.getByName(searchName);
        Integer code = bks != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bks != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bks, msg);
    }

    @PostMapping("/insertBk")
    public Result insertBk(@RequestBody Bk bk) {
        boolean flag = bkService.insert(bk);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @GetMapping("/getBk" + "/{bkId}")
    public Result getBk(@PathVariable String bkId) {
        Bk bk = bkService.getById(Long.valueOf(bkId));
        Integer code = bk != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bk != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bk, msg);
    }

    @PutMapping("/updateBk")
    public Result updateBk(@RequestBody Bk bk) {
        boolean flag = bkService.update(bk);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/deleteBk" + "/{bkId}")
    public Result deleteBk(@PathVariable String bkId) {
        boolean flag = bkService.delete(Long.valueOf(bkId));
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

}
