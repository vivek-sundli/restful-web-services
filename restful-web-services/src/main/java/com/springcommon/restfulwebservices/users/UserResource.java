package com.springcommon.restfulwebservices.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public User getSingleUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id : "+id);
        }
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").
                buildAndExpand(savedUser.getId()).
                toUri();
        return ResponseEntity.created(location).build();
    }
}
