package com.springcommon.restfulwebservices.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    private UserDao service;

    public UserResource(UserDao service){
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUser(){
        return service.findAll();
    }


    @GetMapping(path = "/users/{id}")
    public User getSingleUser(@PathVariable String id){
        return service.findOne(id)  ;
    }
}
