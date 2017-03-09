package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    //   CREATE TABLE Users(id SERIAL, username VARCHAR(255), password VARCHAR(255))

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public List<Admin> getUsers() {
        List<Admin> admins = (List<Admin>)repository.findAll();
        return admins;
    }

    @GetMapping("/add/{username}/{password}")
    public String add(@PathVariable String username, @PathVariable String password) {
        repository.save(new Admin(username, password));
        return "ok";
    }

    @GetMapping("/get/{username}")
    public List<Admin> get(@PathVariable String username) {
        List<Admin> admins = repository.findByUsername(username);
        return admins;
    }

    @GetMapping("/delete/{id}")
    public Iterable<Admin> delete(@PathVariable long id) {
        repository.delete(id);
        return repository.findAll();
    }

    @GetMapping("/delete")
    public Iterable<Admin> deleteAll() {
        repository.deleteAll();
        return repository.findAll();
    }
}
