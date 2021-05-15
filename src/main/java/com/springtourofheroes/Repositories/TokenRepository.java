package com.springtourofheroes.Repositories;

import com.springtourofheroes.Classes.ConfirmationToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends MongoRepository<ConfirmationToken, String> {
    ConfirmationToken save(ConfirmationToken confirmationToken);

    Optional<ConfirmationToken> findByToken(String token);

    void deleteById(String id);
}
