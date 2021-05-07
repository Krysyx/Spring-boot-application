package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.AccountActivationEmail;
import com.springtourofheroes.Classes.ConfirmationToken;
import com.springtourofheroes.Classes.Register;
import com.springtourofheroes.Exceptions.UnmatchedPasswordsException;
import com.springtourofheroes.Helpers.PasswordHelper;
import com.springtourofheroes.Helpers.RandomStringGenerator;
import com.springtourofheroes.Services.EmailService;
import com.springtourofheroes.Services.RegisterService;
import com.springtourofheroes.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/api/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/create")
    public void register(@Valid @RequestBody Register form) {
        if (!PasswordHelper.compare(form.getPassword(), form.getConfirmpassword())) {
            throw new UnmatchedPasswordsException("Passwords do not match");
        }

        Register createdAccount = this.registerService.register(form);

        String confirmationToken = RandomStringGenerator.generateString();
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime expireAt = LocalDateTime.now().plusHours(24);

        ConfirmationToken token = new ConfirmationToken(confirmationToken, createdAt, expireAt, createdAccount.getId());
        ConfirmationToken createdToken = this.tokenService.createToken(token);
        AccountActivationEmail activation = new AccountActivationEmail(createdAccount.getEmail(), createdToken.getToken());

        this.emailService.sendMessage(activation.getEmail(), activation.getSubject(), activation.getText());

//        return "Account" + createdAccount.getUsername() + "successfully created. Please verify your email to activate your account";
    }
}
