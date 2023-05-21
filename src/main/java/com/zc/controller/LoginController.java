package com.zc.controller;


import com.zc.domain.Admin;
import com.zc.domain.Bk;
import com.zc.domain.Sysadmin;
import com.zc.domain.User;
import com.zc.service.AdminService;
import com.zc.service.BkService;
import com.zc.service.SysadminService;
import com.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private BkService bkService;

    @Autowired
    private SysadminService sysadminService;

    @PostMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        User user = userService.loginUser(Integer.valueOf(id), password);
        Admin admin = adminService.loginAdmin(Integer.valueOf(id), password);
        Bk bk = bkService.loginBk(Integer.valueOf(id), password);
        Sysadmin sysadmin = sysadminService.loginSysadmin(Integer.valueOf(id), password);

        if (user != null || admin != null || bk != null || sysadmin != null) {
            session.setAttribute("UserSession", user);
            if (user != null) {
                session.setAttribute("UserSession", user);
                response.sendRedirect("/user/index.html");
            } else if (admin != null) {
                session.setAttribute("UserSession", admin);
                response.sendRedirect("/admin/index.html");
            } else if (bk != null) {
                session.setAttribute("UserSession", bk);
                response.sendRedirect("/bk/index.html");
            } else {
                session.setAttribute("UserSession", sysadmin);
                response.sendRedirect("/sysadmin/index.html");
            }
        } else {
            response.sendRedirect("/login.html");
        }
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        session.removeAttribute("UserSession");
        response.sendRedirect("/login.html");
    }

}

