package com.springtourofheroes.Services;

import com.springtourofheroes.Classes.User;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    User register(User user);

    User findById(String id);
}
