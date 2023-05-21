package com.zc.controller;

import com.zc.controller.other.Code;
import com.zc.controller.other.Result;
import com.zc.domain.*;
import com.zc.service.AdminService;
import com.zc.service.BfdService;
import com.zc.service.JfdzService;
import com.zc.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProjectService pjService;

    @Autowired
    private JfdzService jfdzService;

    @Autowired
    private BfdService bfdService;

    @Autowired
    private AdminService adminService;

    /*查找所有申报的项目*/
    @GetMapping("/getAllSb")
    public Result getAllSb() {
        List<Pj> pjs = pjService.selectAll();
        Integer code = pjs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pjs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pjs, msg);
    }

    /*查询所有经费到账表*/
    @GetMapping("/getAllJfdz")
    public Result getAllJfdz() {
        List<Jfdz> jfdzs = jfdzService.selectAll();
        Integer code = jfdzs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = jfdzs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, jfdzs, msg);
    }

    /*通过项目名字中的关键字查找申报的项目*/
    @GetMapping("/getPjByName")
    public Result getPjByName(@RequestParam String searchName) {
        List<Pj> pjs = pjService.selectByPjName(searchName);
        Integer code = pjs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pjs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pjs, msg);
    }


    @GetMapping("/getJfdzByName")
    public Result getJfdzByName(@RequestParam String searchName) {
        List<Jfdz> jfdzs = jfdzService.selectByNumber(searchName);
        Integer code = jfdzs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = jfdzs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, jfdzs, msg);
    }

    @GetMapping("/getPjByNameSh")
    public Result getPjByNameSh(@RequestParam String searchName) {
        List<Pj> pjs = pjService.selectByPjNameSh(searchName);
        Integer code = pjs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pjs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pjs, msg);
    }

    @GetMapping("/getAllBfd")
    public Result getAllBfd() {
        List<Bfd> bfds = bfdService.selectAll();
        Integer code = bfds != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bfds != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bfds, msg);
    }

    @GetMapping("/getBfdByNumber")
    public Result getBfdByNumber(@RequestParam String searchName) {
        List<Bfd> bfds = bfdService.selectByNumber(searchName);
        Integer code = bfds != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bfds != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bfds, msg);
    }

    /*对申报项目进行审核*/
    @PostMapping("/sbSh")
    public Result sbSh(@RequestBody Pj pj) {
        Pj pj1 = pjService.selectById(Long.valueOf(pj.getPjId()));
        if (pj1.getPjShstatus().equals("1")) {
            return new Result("项目已审核，无法修改");
        }

        pj1.setPjShstatus(pj.getPjShstatus());
        int year = java.time.Year.now().getValue();
        String result = "HX" + year + pj1.getPjId();
        pj1.setPjNumber(result);

        boolean flag = pjService.updateByPrimaryKeySelective(pj1);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    /*补充合同审核*/
    @PostMapping("/bcSh")
    public Result bcSh(@RequestBody Pj pj) {
        Pj pj1 = pjService.selectById(Long.valueOf(pj.getPjId()));
        if (pj1.getPjBcstatus().equals("1")) {
            return new Result("已审核的合同无法修改");
        }
        pj1.setPjBcstatus(pj.getPjBcstatus());
        boolean flag = pjService.updateByPrimaryKeySelective(pj1);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @PostMapping("/dzSh")
    public Result dzSh(@RequestBody Jfdz jfdz) {
        Jfdz jfdz1 = jfdzService.selectById(Long.valueOf(jfdz.getDzId()));
        if (jfdz1.getDzStatus().equals("1")) {
            return new Result("已审核的报账单无法修改");
        }
        jfdz1.setDzStatus(jfdz.getDzStatus());
        boolean flag = jfdzService.update(jfdz1);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @PostMapping("/bfdSh")
    public Result bfdSh(@RequestBody Bfd bfd) {
        Bfd bfd1 = bfdService.getById(bfd.getId());
        if (bfd1.getAdminStatus().equals("1")) {
            return new Result("已审核的报账单无法修改");
        }
        bfd1.setAdminStatus(bfd.getAdminStatus());
        boolean flag = bfdService.update(bfd1);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    /*项目结题审核*/
    @PostMapping("/jtSh")
    public Result jtSh(@RequestBody Pj pj) {
        Pj pj1 = pjService.selectById(Long.valueOf(pj.getPjId()));
        if (pj1.getPjJtstatus().equals("2")) {
            return new Result("已结题的合同无法修改");
        } else if (pj1.getPjJtstatus().equals("0")) {
            return new Result("该项目未申请结题");
        } else {
            pj1.setPjJtime(new Date());
            pj1.setPjJtstatus(pj.getPjJtstatus());
            boolean flag = pjService.updateByPrimaryKeySelective(pj1);
            return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
        }
    }

    /*查找所有已立项的项目*/
    @GetMapping("/getAllLx")
    public Result getAllLx() {
        List<Pj> pjs = pjService.selectAllLx();
        Integer code = pjs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pjs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, pjs, msg);
    }

    @PutMapping("/update")
    public Result updateById(@RequestBody Pj project) {
        boolean flag = pjService.updateByPrimaryKeySelective(project);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @GetMapping("/getMyself")
    public Result getMyself(HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("UserSession");
        Integer code = admin != null ? Code.GET_OK : Code.GET_ERR;
        String msg = admin != null ? "" : "数据查询失败，请重试！";
        return new Result(code, admin, msg);
    }

    @PostMapping("/updatePwd")
    public Result updatePwd(HttpServletRequest request, @RequestBody PasswordRequest passwordRequest){
        Admin admin = (Admin) request.getSession().getAttribute("UserSession");
        if (passwordRequest.getOldPassword().equals(admin.getAdminPwd())) {
            admin.setAdminPwd(passwordRequest.getNewPassword());
            boolean flag = adminService.updateById(admin);

            return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
        }
        return new Result("更改出现错误，请稍后重试！");
    }

    @GetMapping("/getByXy")
    public Result getByXy(){
        List<XySum> byXy = adminService.getByXy();
        Integer code = byXy != null ? Code.GET_OK : Code.GET_ERR;
        String msg = byXy != null ? "" : "数据查询失败，请重试！";
        return new Result(code, byXy, msg);
    }
}
