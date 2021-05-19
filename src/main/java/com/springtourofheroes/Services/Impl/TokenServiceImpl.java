package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.ConfirmationToken;
import com.springtourofheroes.Classes.TokenValidity;
import com.springtourofheroes.Classes.User;
import com.springtourofheroes.Exceptions.NotFoundException;
import com.springtourofheroes.Exceptions.TokenExpiredException;
import com.springtourofheroes.Helpers.RandomStringGenerator;
import com.springtourofheroes.Repositories.TokenRepository;
import com.springtourofheroes.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public ConfirmationToken createToken(String id) {
        ConfirmationToken token = new ConfirmationToken(RandomStringGenerator.generateString(), id);
        return this.tokenRepository.save(token);
    }

    @Override
    public ConfirmationToken verify(String t) {
        LocalDateTime now = LocalDateTime.now();
        Optional<ConfirmationToken> token = this.tokenRepository.findByToken(t);

        if (token.isEmpty()) {
            throw new NotFoundException("Token not found");
        }

        ConfirmationToken validatedToken = token.get();

        if (now.isAfter(validatedToken.getExpireAt())) {
            this.tokenRepository.deleteById(validatedToken.getId());
            throw new TokenExpiredException("This link is not valid anymore. Please sign in again in order to get a new one");
        }

        return validatedToken;
    }

    @Override
    public ConfirmationToken verifyTokenValidity(String t) {
        Optional<ConfirmationToken> token = this.tokenRepository.findByToken(t);

        if(token.isEmpty()) {
            throw new NotFoundException("Invalid token");
        }

        return token.get();
    }

    @Override
    public ConfirmationToken findByToken(String t) {
        Optional<ConfirmationToken> token = this.tokenRepository.findByToken(t);

        if (token.isEmpty()) {
            throw new NotFoundException("Token does not exist");
        }

        return token.get();
    }
}
