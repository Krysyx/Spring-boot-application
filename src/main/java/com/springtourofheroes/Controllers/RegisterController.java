package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.Register;
import com.springtourofheroes.Exceptions.UnmatchedPasswordsException;
import com.springtourofheroes.Helpers.PasswordHelper;
import com.springtourofheroes.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/register")
public class RegisterController {
    @Autowired
    private static RegisterService registerService;

    @Autowired
    private static PasswordHelper passwordHelper;

    @PostMapping("/create")
    public String register(@Valid @RequestBody Register form) {
        if (!passwordHelper.compare(form.getPassword(), form.getConfirmpassword())) {
            throw new UnmatchedPasswordsException("Passwords do not match");
        }

        Register createdAccount = registerService.register(form);
        return "Account" + createdAccount.getUsername() + "successfully created";
    }
}
