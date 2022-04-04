package com.example.music.domain;

import java.io.Serializable;

/**
 * 管理员    //为了前后台传输还需要序列号 Serializable
 */
public class Admin implements Serializable {

    /*住建*/
    private Integer id;
    /*账号*/
    private String name;
    /*密码*/
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
