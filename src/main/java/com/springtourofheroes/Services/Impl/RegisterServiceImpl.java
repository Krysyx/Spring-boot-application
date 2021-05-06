package com.springtourofheroes.Services.Impl;

import com.springtourofheroes.Classes.Register;
import com.springtourofheroes.Repositories.RegisterRepository;
import com.springtourofheroes.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private static RegisterRepository registerRepository;

    @Override
    public Register register(Register form) {
        return registerRepository.save(form);
    }
}
