package com.bjsxt.pojo;

import java.io.Serializable;

public class Admin implements Serializable {


    private   String   username;

    private   String   password;

    private    String  salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
