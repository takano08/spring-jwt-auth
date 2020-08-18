package com.rdbf.demo.apiauth.controller.form;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserForm {
    private String loginId;
    private String password;

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public void encrypt(PasswordEncoder encoder){
        this.password = encoder.encode(password);
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
