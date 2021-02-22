package com.management.salessystem.controller

import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.management.salessystem.response.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class RestExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorResponse handleException(NoSuchElementException exception, HttpServletRequest request) {
        new ErrorResponse(cause: [exception.message], path: request.servletPath)
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleException(IllegalArgumentException exception, HttpServletRequest request) {
        new ErrorResponse(cause: [exception.message], path: request.servletPath)
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleException(IllegalStateException exception, HttpServletRequest request) {
        new ErrorResponse(cause: [exception.message], path: request.servletPath)
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    ErrorResponse handleException(InvalidFormatException exception, HttpServletRequest request) {
        new ErrorResponse(cause: ['Unprocessable entity'], path: request.servletPath)
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponse handleException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        new ErrorResponse(cause: exception.allErrors.collect {
            it.defaultMessage
        }, path: request.servletPath)
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ErrorResponse handleException(Exception exception, HttpServletRequest request) {
        new ErrorResponse(cause: [exception.message], path: request.servletPath)
    }
}

