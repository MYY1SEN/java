package com.myq.springbootfreemarker.pojo;

public class User {
    private String username;
    private String usersex;
    private String userage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserage() {
        return userage;
    }

    public void setUserage(String userage) {
        this.userage = userage;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userage='" + userage + '\'' +
                '}';
    }

    public User(String username, String usersex, String userage) {
        this.username = username;
        this.usersex = usersex;
        this.userage = userage;
    }
    public User(){

    }
}
