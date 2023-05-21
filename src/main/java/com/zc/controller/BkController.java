package com.zc.controller;

import com.zc.controller.other.Code;
import com.zc.controller.other.Result;
import com.zc.domain.*;
import com.zc.service.BfdService;
import com.zc.service.BkService;
import com.zc.service.BzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/bk")
public class BkController {

    @Autowired
    private BfdService bfdService;

    @Autowired
    private BkService bkService;

    @Autowired
    private BzService bzService;

    @PostMapping("/bfdSh")
    public Result bfdSh(@RequestBody Bfd bfd) {
        Bfd bfd1 = bfdService.getById(bfd.getId());
        if (bfd1.getBkStatus().equals("1")) {
            return new Result("已审核的报账单无法修改");
        }
        bfd1.setBkStatus(bfd.getBkStatus());
        boolean flag = bfdService.update(bfd1);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @GetMapping("/getMyself")
    public Result getMyself(HttpServletRequest request) {
        Bk bk = (Bk) request.getSession().getAttribute("UserSession");
        Integer code = bk != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bk != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bk, msg);
    }

    @PostMapping("/updatePwd")
    public Result updatePwd(HttpServletRequest request, @RequestBody PasswordRequest passwordRequest) {
        Bk bk = (Bk) request.getSession().getAttribute("UserSession");
        if (passwordRequest.getOldPassword().equals(bk.getBkPwd())) {
            bk.setBkPwd(passwordRequest.getNewPassword());
            boolean flag = bkService.update(bk);

            return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
        }
        return new Result("更改出现错误，请稍后重试！");
    }

    @GetMapping("/getAllBz")
    public Result getAllBz() {
        List<Bz> bzs = bzService.getAll();
        Integer code = bzs != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bzs != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bzs, msg);
    }

    @GetMapping("/getById" + "/{id}")
    public Result getById(@PathVariable String id) {
        Bz bz = bzService.getById(id);
        Integer code = bz != null ? Code.GET_OK : Code.GET_ERR;
        String msg = bz != null ? "" : "数据查询失败，请重试！";
        return new Result(code, bz, msg);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Bz bz) {
        if (bz.getBzStatus().equals("1")) {
            return new Result("已审核完成的报账单无法修改！");
        }
        boolean flag = bzService.update(bz);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @PostMapping("/bz")
    public Result bz(@RequestBody Bz bz) {
        Bz bz1 = bzService.getById(String.valueOf(bz.getId()));

        if (bz1.getBzStatus().equals("1")) {
            return new Result("已审核的报账单无法修改");
        }
        bz1.setBzStatus(bz.getBzStatus());
        boolean flag = bzService.update(bz1);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }
}
