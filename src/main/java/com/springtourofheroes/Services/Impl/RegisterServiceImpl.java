package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.User;
import com.springtourofheroes.Exceptions.UnmatchedPasswordsException;
import com.springtourofheroes.Helpers.PasswordHelper;
import com.springtourofheroes.Repositories.RegisterRepository;
import com.springtourofheroes.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public User register(User user) {
        if (!passwordHelper.compare(user.getPassword(), user.getConfirmpassword())) {
            throw new UnmatchedPasswordsException("Passwords do not match");
        }

        user.setPassword(passwordHelper.encode(user.getPassword()));
        return this.registerRepository.save(user);
    }
}
