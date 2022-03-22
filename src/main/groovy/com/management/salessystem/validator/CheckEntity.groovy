package com.management.salessystem.validator

import org.springframework.data.repository.CrudRepository

import javax.validation.Constraint
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Target([ElementType.FIELD, ElementType.PARAMETER])
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEntityValidator.class)
@interface CheckEntity {
    Class<CrudRepository> repository()

    String message() default "Entity validation error"

    boolean exists() default true

    Class[] groups() default []

    Class[] payload() default []
}