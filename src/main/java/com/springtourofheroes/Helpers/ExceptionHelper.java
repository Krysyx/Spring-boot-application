package com.springtourofheroes.Helpers;

import com.mongodb.MongoWriteException;
import com.springtourofheroes.Errors.ErrorHandlerDomain;
import com.springtourofheroes.Exceptions.UnmatchedPasswordsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.mail.MessagingException;
import javax.validation.UnexpectedTypeException;

@RestControllerAdvice
public class ExceptionHelper {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorHandlerDomain> handleValidationException(MethodArgumentNotValidException exception) {
        logger.error("Invalid input received : " + exception.getMessage());
        ErrorHandlerDomain error = new ErrorHandlerDomain(exception.getMessage(), "Invalid input received", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<ErrorHandlerDomain> handleTypeException(UnexpectedTypeException exception) {
        logger.error("Invalid type : " + exception.getMessage());
        ErrorHandlerDomain errors = new ErrorHandlerDomain(exception.getMessage(), "Invalid value type received", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorHandlerDomain> handleMessageNotReadableException(HttpMessageNotReadableException exception) {
        logger.warn("Http message not readable : " + exception.getMessage());
        ErrorHandlerDomain error = new ErrorHandlerDomain(exception.getMessage(), "Http message not readable", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<ErrorHandlerDomain> handleMongoWriteException(MongoWriteException exception) {
        logger.error("Duplicate key found : " + exception.getMessage());
        ErrorHandlerDomain error = new ErrorHandlerDomain(exception.getMessage(), "An hero with this name already exists", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnmatchedPasswordsException.class)
    public ResponseEntity<ErrorHandlerDomain> handleUnmatchedPasswordException(UnmatchedPasswordsException exception) {
        logger.error("Passwords did not match : " + exception.getMessage());
        ErrorHandlerDomain error = new ErrorHandlerDomain(exception.getMessage(), "Passwords must match", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<ErrorHandlerDomain>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<ErrorHandlerDomain> handleMessagingException(MessagingException exception) {
        logger.error("An email sending error occured : " + exception.getMessage());
        ErrorHandlerDomain error = new ErrorHandlerDomain(exception.getMessage(), "An error occured while trying to send an email", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
