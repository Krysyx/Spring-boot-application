package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.ConfirmationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TokenService {
    ConfirmationToken createToken(ConfirmationToken confirmationToken);

    ConfirmationToken verify(String token);
}
