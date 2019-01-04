package com.learningstuff.livedatareadbyajax.userService;

import com.learningstuff.livedatareadbyajax.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public List<User> userList()
    {
        return users;
    }

    public void addDate(User user)
    {
        users.add(user);
    }
    public void updateData(User user)
    {
        users.stream().forEach(p -> {
            if(p.getId() == user.getId())
            {
                p.setName(user.getName());
            }
        });
    }

}
