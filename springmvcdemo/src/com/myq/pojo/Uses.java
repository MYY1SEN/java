package com.myq.pojo;

import java.util.List;

public class Uses {
    private String username;
    private List<String> userlike;
    private Address address;

    @Override
    public String toString() {
        return "Uses{" +
                "username='" + username + '\'' +
                ", userlike=" + userlike +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getUserlike() {
        return userlike;
    }

    public void setUserlike(List<String> userlike) {
        this.userlike = userlike;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
