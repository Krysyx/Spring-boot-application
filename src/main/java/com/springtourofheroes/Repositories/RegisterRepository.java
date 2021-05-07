package com.springtourofheroes.Repositories;

import com.springtourofheroes.Classes.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends MongoRepository<User, String> {
    User save(User form);
}
