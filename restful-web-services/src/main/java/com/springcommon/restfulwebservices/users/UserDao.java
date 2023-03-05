package com.springcommon.restfulwebservices.users;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class UserDao {
    static List<User> users = new ArrayList<>();
    private static int usersCount=0;
    static {
        users.add(new User(++usersCount,"Vivek", LocalDate.now().minusYears(24)));
        users.add(new User(++usersCount,"Kartik", LocalDate.now().minusYears(34)));
        users.add(new User(++usersCount,"Arsh", LocalDate.now().minusYears(65)));
    }

    public List<User> findAll(){
        return users;
    }
    public User findOne(int id){
        Predicate<? super User> predicate = user -> Objects.equals(user.getId(), id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {

        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
