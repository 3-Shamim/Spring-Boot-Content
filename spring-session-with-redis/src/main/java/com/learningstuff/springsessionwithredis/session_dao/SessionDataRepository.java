package com.learningstuff.springsessionwithredis.session_dao;


import com.learningstuff.springsessionwithredis.model.User;

import java.util.Map;

public interface SessionDataRepository {

    void save(User user);
    Map<String, User> findAll();
    User findById(String id);
    void update(User user);
    void delete(String id);
}
