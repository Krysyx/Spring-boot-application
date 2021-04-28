package com.springtourofheroes.Helpers;

import com.mongodb.MongoWriteException;
import com.springtourofheroes.Errors.ErrorHandlerDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.UnexpectedTypeException;

@RestControllerAdvice
public class ExceptionHelper {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorHandlerDomain> handleValidationException(MethodArgumentNotValidException exception) {
        logger.error("Invalid input received : " + exception.getMessage());
        ErrorHandlerDomain error = new ErrorHandlerDomain(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<ErrorHandlerDomain> handleTypeException(UnexpectedTypeException exception) {
        logger.error("Invalid type : " + exception.getMessage());
        ErrorHandlerDomain errors = new ErrorHandlerDomain(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorHandlerDomain> handleMessageNotReadableException(HttpMessageNotReadableException exception) {
        logger.warn("Http message not readable : " + exception.getMessage());
        ErrorHandlerDomain error = new ErrorHandlerDomain(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<ErrorHandlerDomain> handleMongoWriteException(MongoWriteException exception) {
        logger.error("Duplicate key found : " + exception.getMessage());
        ErrorHandlerDomain error = new ErrorHandlerDomain(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
