package com.zc.domain;

import lombok.Data;

@Data
public class Admin {
    private Long adminId;
    private String adminName;
    private String adminSex;
    private String adminPhone;
    private String adminPwd;
    private String role;
}
