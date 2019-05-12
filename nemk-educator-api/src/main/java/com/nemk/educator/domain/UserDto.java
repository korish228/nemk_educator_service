package com.nemk.educator.domain;


import com.nemk.educator.model.User;

import java.io.Serializable;

public class UserDto implements Serializable {

    private User user;
    private String token;

    public UserDto(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
