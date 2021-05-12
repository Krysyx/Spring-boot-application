package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.ConfirmationToken;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {
    ConfirmationToken createToken(ConfirmationToken confirmationToken);

    ConfirmationToken verify(String token);
}
