package com.springtourofheroes.Repositories;

import com.springtourofheroes.Classes.ConfirmationToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends MongoRepository<ConfirmationToken, String> {
    ConfirmationToken save(ConfirmationToken confirmationToken);

    ConfirmationToken findByToken(String token);
}
