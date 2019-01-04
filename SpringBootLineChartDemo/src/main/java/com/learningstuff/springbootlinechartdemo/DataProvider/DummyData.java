package com.learningstuff.springbootlinechartdemo.DataProvider;

import com.learningstuff.springbootlinechartdemo.Model.User;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1, 100, 200, 80));
        userList.add(new User(2, 60, 150, 180));
        userList.add(new User(3, 50, 90, 120));
        userList.add(new User(4, 70, 80, 155));
    }

    public List<User> getUserList()
    {
        return userList;
    }

}
