package com.springtourofheroes.Repositories;

import com.springtourofheroes.Classes.Register;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends MongoRepository<Register, String> {
    Register save(Register form);
}
