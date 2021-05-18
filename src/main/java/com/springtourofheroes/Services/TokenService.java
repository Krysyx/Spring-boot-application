package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.ConfirmationToken;
import com.springtourofheroes.Classes.User;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {
    ConfirmationToken createToken(User user);

    ConfirmationToken verify(String token);

    boolean verifyTokenValidity(String token);

    ConfirmationToken findByToken(String token);
}
