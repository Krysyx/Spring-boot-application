package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.User;
import com.springtourofheroes.Exceptions.NotFoundException;
import com.springtourofheroes.Exceptions.UnmatchedPasswordsException;
import com.springtourofheroes.Helpers.PasswordHelper;
import com.springtourofheroes.Repositories.RegisterRepository;
import com.springtourofheroes.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    @Override
    public User findById(String id) {
        Optional<User> user = this.registerRepository.findById(id);

        if (user.isEmpty()) {
            throw new NotFoundException("User does not exist");
        }

        return user.get();
    }

    @Override
    public User validate(User user) {
        return this.registerRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> user = this.registerRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new NotFoundException("User does not exist");
        }

        return user.get();
    }
}
