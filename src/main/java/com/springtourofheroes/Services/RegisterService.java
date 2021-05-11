package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.User;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    abstract User register(User user);
}
