package com.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Admin, Long> {
    List<Admin> findByUsername(String lastName);
}
