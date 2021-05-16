package com.springtourofheroes.Classes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Document(collection = "tokens")
public class ConfirmationToken {
    @Id
    private String id;
    @NotNull
    private String token;
    @DateTimeFormat
    private final static LocalDateTime createdAt = LocalDateTime.now();
    @DateTimeFormat
    private final static LocalDateTime expireAt = LocalDateTime.now().plusHours(24);
    private String user_id;

    public ConfirmationToken(@NotNull String token, String user_id) {
        this.token = token;
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
