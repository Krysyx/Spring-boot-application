package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.User;
import com.springtourofheroes.Repositories.RegisterRepository;
import com.springtourofheroes.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public User register(User form) {
        return this.registerRepository.save(form);
    }
}
