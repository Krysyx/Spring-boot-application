package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.ConfirmationToken;
import com.springtourofheroes.Repositories.TokenRepository;
import com.springtourofheroes.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public ConfirmationToken createToken(ConfirmationToken confirmationToken) {
        return this.tokenRepository.save(confirmationToken);
    }
}
