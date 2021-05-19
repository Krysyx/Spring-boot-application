package com.springtourofheroes.Repositories;

import com.springtourofheroes.Classes.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends MongoRepository<User, String> {
    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByEmail(String email);
}
