package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.Register;
import com.springtourofheroes.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/register")
public class RegisterController {
    @Autowired
    private static RegisterService registerService;

    @PostMapping("/create")
    public String register(@RequestBody Register form) {
        Register createdAccount = registerService.register(form);
        return "Account" + createdAccount.getUsername() + "successfully created";
    }
}
