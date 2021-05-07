package com.springtourofheroes.Repositories;

import com.springtourofheroes.Classes.ConfirmationToken;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository {
    ConfirmationToken save(ConfirmationToken confirmationToken);
}
