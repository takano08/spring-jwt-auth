package com.rdbf.demo.apiauth.domain;

public class People {
    private String peopleId;
    private String loginId;
    private String password;

    public People(String peopleId, String loginId, String password) {
        this.peopleId = peopleId;
        this.loginId = loginId;
        this.password = password;
    }

    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
