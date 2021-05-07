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
    private LocalDateTime createdAt;
    @DateTimeFormat
    private LocalDateTime expireAt;
    private String user_id;

    public ConfirmationToken(@NotNull String token, LocalDateTime createdAt, LocalDateTime expireAt, String user_id) {
        this.token = token;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
