package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.AccountActivationEmail;
import com.springtourofheroes.Classes.ConfirmationToken;
import com.springtourofheroes.Classes.User;
import com.springtourofheroes.Helpers.MailLinkGenerator;
import com.springtourofheroes.Helpers.RandomStringGenerator;
import com.springtourofheroes.Services.EmailService;
import com.springtourofheroes.Services.RegisterService;
import com.springtourofheroes.Services.TokenService;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @Autowired
    private MailLinkGenerator mailLinkGenerator;

    @PostMapping("/create")
    public String register(@Valid @RequestBody User user) throws MessagingException {
        User createdUser = this.registerService.register(user);

        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime expireAt = LocalDateTime.now().plusMinutes(1);
//      LocalDateTime expireAt = LocalDateTime.now().plusHours(24);
        ConfirmationToken token = new ConfirmationToken(RandomStringGenerator.generateString(), createdAt, expireAt, createdUser.getId());
        ConfirmationToken createdToken = this.tokenService.createToken(token);

        AccountActivationEmail activation = new AccountActivationEmail(mailLinkGenerator.getEmailLink(createdToken.getToken()));
        this.emailService.sendMessage(createdUser.getEmail(), activation.getSUBJECT(), activation.getText());
        return "Account " + createdUser.getUsername() + " successfully created. Please verify your email to activate your account";
    }

    @GetMapping("/verify")
    public String verify(@NotNull @RequestParam String token) {
        System.out.println("Verify Account method called");
        ConfirmationToken confirmationToken = this.tokenService.verify(token);
        User user = this.registerService.findById(confirmationToken.getUser_id());
        user.setActivated(true);
        this.registerService.register(user);
        return "Account successfully activated";
    }
}
