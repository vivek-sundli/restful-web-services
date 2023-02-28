package com.springcommon.restfulwebservices.users;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDao {
    static List<User> users = new ArrayList<>();

    static {
        users.add(new User("1","Vivek", LocalDate.now().minusYears(24)));
        users.add(new User("2","Kartik", LocalDate.now().minusYears(34)));
        users.add(new User("3","Arsh", LocalDate.now().minusYears(65)));
    }

    public List<User> findAll(){
        return users;
    }
    public User findOne(String id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

}
