package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.Register;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    abstract Register register(Register form);
}
