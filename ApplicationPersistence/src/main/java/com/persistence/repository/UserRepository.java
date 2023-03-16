package com.persistence.repository;

import com.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);

    void insert(User user);
}
