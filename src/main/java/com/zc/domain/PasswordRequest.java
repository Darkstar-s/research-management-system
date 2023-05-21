package com.zc.domain;

import lombok.Data;

@Data
public class PasswordRequest {
    private String oldPassword;
    private String newPassword;
}
