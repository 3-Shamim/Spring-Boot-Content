package com.learningstuff.springsessionwithredis.session_dao;

import com.learningstuff.springsessionwithredis.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SessionDataRepositoryImpl implements SessionDataRepository{

    private HashOperations hashOperations;


    public SessionDataRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        RedisTemplate<String, User> redisTemplate1 = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
        hashOperations.put("SESSION_DATA", user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("SESSION_DATA");
    }

    @Override
    public User findById(String id) {
        return (User) hashOperations.get("SESSION_DATA", id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("SESSION_DATA",id);
    }
}
