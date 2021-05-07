package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.ConfirmationToken;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {
    abstract ConfirmationToken createToken(ConfirmationToken confirmationToken);
}
