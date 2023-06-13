package com.atmm.jedis;

import java.util.List;

public class UserArray {
    List<User> users;

    public UserArray(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserArray{" +
                "users=" + users +
                '}';
    }
}
