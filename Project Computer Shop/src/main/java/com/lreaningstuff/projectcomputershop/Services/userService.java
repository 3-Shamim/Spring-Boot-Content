package com.lreaningstuff.projectcomputershop.Services;

import com.lreaningstuff.projectcomputershop.Model.Users;

import java.util.ArrayList;
import java.util.List;

public class userService {
    private List<Users> usersList = new ArrayList<>();

    public void saveUser(Users users)
    {
        usersList.add(users);
    }

    public List<Users> getUser()
    {
        return usersList;
    }
}
