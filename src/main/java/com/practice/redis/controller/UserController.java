package com.practice.redis.controller;

import com.practice.redis.domain.User;
import com.practice.redis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id, @PathVariable("name") final String name){
        userRepository.save(new User(id, name, 20000L));
        return userRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id, @PathVariable("name") final String name){
        userRepository.save(new User(id, name, 1000L));
        return userRepository.findById(id);
    }

    @GetMapping("/all")
    public Map<String, User> all(){
        return userRepository.findAll();
    }

}
