package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.AccountActivationEmail;
import com.springtourofheroes.Classes.ConfirmationToken;
import com.springtourofheroes.Classes.User;
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
    public void register(@Valid @RequestBody User user) {
        if (!PasswordHelper.compare(user.getPassword(), user.getConfirmpassword())) {
            throw new UnmatchedPasswordsException("Passwords do not match");
        }

        User createdUser = this.registerService.register(user);
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime expireAt = LocalDateTime.now().plusHours(24);

        ConfirmationToken token = new ConfirmationToken(RandomStringGenerator.generateString(), createdAt, expireAt, createdUser.getId());
        ConfirmationToken createdToken = this.tokenService.createToken(token);

        AccountActivationEmail activation = new AccountActivationEmail(createdToken.getToken());
        System.out.println(activation.getSUBJECT());
        this.emailService.sendMessage(createdUser.getEmail(), activation.getSUBJECT(), activation.getText());

//        return "Account" + createdUser.getUsername() + "successfully created. Please verify your email to activate your account";
    }
}
