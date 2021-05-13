package com.springtourofheroes.Controllers;

import com.springtourofheroes.Classes.AccountActivationEmail;
import com.springtourofheroes.Classes.ConfirmationToken;
import com.springtourofheroes.Classes.User;
import com.springtourofheroes.Exceptions.NotFoundException;
import com.springtourofheroes.Exceptions.TokenExpiredException;
import com.springtourofheroes.Helpers.MailLinkGenerator;
import com.springtourofheroes.Helpers.RandomStringGenerator;
import com.springtourofheroes.Services.EmailService;
import com.springtourofheroes.Services.RegisterService;
import com.springtourofheroes.Services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

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
        LocalDateTime expireAt = LocalDateTime.now().plusHours(24);
        ConfirmationToken token = new ConfirmationToken(RandomStringGenerator.generateString(), createdAt, expireAt, createdUser.getId());
        ConfirmationToken createdToken = this.tokenService.createToken(token);

        AccountActivationEmail activation = new AccountActivationEmail(mailLinkGenerator.getEmailLink(createdToken.getToken()));
        this.emailService.sendMessage(createdUser.getEmail(), activation.getSUBJECT(), activation.getText());
        return "Account " + createdUser.getUsername() + " successfully created. Please verify your email to activate your account";
    }

    @GetMapping("/verify")
    public String verify(@NotNull @RequestParam String token) {
        LocalDateTime now = LocalDateTime.now();
        ConfirmationToken confirmationToken = this.tokenService.verify(token);

        if (now.isAfter(confirmationToken.getExpireAt())) {
            throw new TokenExpiredException("This link is not valid anymore. Please sign in again in order to get a new one");
        }

        Optional<User> user = this.registerService.findById(confirmationToken.getUser_id());

        if (user.isEmpty()) {
            throw new NotFoundException("User does not exist");
        }

        user.get().setActivated(true);
        this.registerService.register(user.get());
        return "Account successfully activated";
    }
}
