package com.practice.redis.repository;

import com.practice.redis.domain.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private RedisTemplate<String, User> redisTemplate;
    //레디스 서버에 데이터 작업을 수행하는 스프링 메서드의 집합
    private HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate){
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public void save(User user) {
        hashOperations.put("USER", user.getId(), user);
    }

    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public User findById(String id) {
        return (User) hashOperations.get("USER", id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("USER", id);
    }
}
