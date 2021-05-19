package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.ConfirmationToken;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {
    ConfirmationToken createToken(String id);

    ConfirmationToken verify(String token);

    ConfirmationToken verifyTokenValidity(String token);

    ConfirmationToken findByToken(String token);
}
