package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.Register;
import com.springtourofheroes.Exceptions.UnmatchedPasswordsException;
import com.springtourofheroes.Helpers.PasswordHelper;
import com.springtourofheroes.Services.EmailService;
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
    private RegisterService registerService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/create")
    public void register(@Valid @RequestBody Register form) {
        if (!PasswordHelper.compare(form.getPassword(), form.getConfirmpassword())) {
            throw new UnmatchedPasswordsException("Passwords do not match");
        }
        Register createdAccount = this.registerService.register(form);
//        var email = new AccountActivationEmail(createdAccount.getEmail())
//        this.emailService.sendMessage(createdAccount.getEmail(), );
//        return "Account" + createdAccount.getUsername() + "successfully created. Please verify your email to activate your account";
    }
}
