package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.*;
import com.springtourofheroes.Helpers.MailLinkGenerator;
import com.springtourofheroes.Services.EmailService;
import com.springtourofheroes.Services.RegisterService;
import com.springtourofheroes.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private MailLinkGenerator mailLinkGenerator;

    @PostMapping("/create")
    public String register(@Valid @RequestBody User user) throws MessagingException {
        User createdUser = this.registerService.register(user);
        ConfirmationToken createdToken = this.tokenService.createToken(createdUser.getId());
        AccountActivationEmail email = new AccountActivationEmail(createdUser.getEmail(), mailLinkGenerator.getEmailLink(createdToken.getToken()));
        this.emailService.sendMessage(email);
        return "Account " + createdUser.getUsername() + " successfully created. Please verify your email to activate your account";
    }

    @GetMapping("/verify")
    public ValidatedAccount verify(@NotNull @RequestParam String token) {
        ConfirmationToken confirmationToken = this.tokenService.verify(token);
        User user = this.registerService.findById(confirmationToken.getUserId());
        user.setActivated(true);
        User validatedUser = this.registerService.validate(user);
        return new ValidatedAccount(validatedUser);
    }

    @GetMapping("/validity/{token}")
    public ValidatedToken verifyTokenValidity(@PathVariable String token) {
        ConfirmationToken validatedToken = this.tokenService.verifyTokenValidity(token);
        return new ValidatedToken(validatedToken.getUserId());
    }

    @PostMapping("/refresh_token")
    public String refreshToken(@NotNull @RequestParam String email) throws MessagingException {
        User user = this.registerService.findByEmail(email);
        ConfirmationToken createdToken = this.tokenService.createToken(user.getId());
        AccountActivationEmail emailActivation = new AccountActivationEmail(user.getEmail(), mailLinkGenerator.getEmailLink(createdToken.getToken()));
        this.emailService.sendMessage(emailActivation);
        return "A new activation link has been sent to your email";
    }
}
