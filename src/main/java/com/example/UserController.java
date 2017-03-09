package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public List<User> getUsers() {
        List<User> users = (List<User>)repository.findAll();
        return users;
    }

    @GetMapping("/add/{username}/{password}")
    public User addUser(@PathVariable String username, @PathVariable String password) {
        User user = repository.save(new User(username, password));
        return repository.findOne(user.getId());
    }

    @GetMapping("/get/{username}")
    public List<User> getUser(@PathVariable String username) {
        List<User> users = repository.findByUsername(username);
        return users;
    }

    @GetMapping("/delete/{id}")
    public Iterable<User> deleteUser(@PathVariable long id) {
        repository.delete(id);
        return repository.findAll();
    }

    @GetMapping("/delete")
    public Iterable<User> deleteAll() {
        repository.deleteAll();
        return repository.findAll();
    }
}
