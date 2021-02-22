package com.management.salessystem.validator

import org.springframework.data.repository.CrudRepository

import javax.validation.Constraint
import java.lang.annotation.*

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckEntityValidator.class)
@interface CheckEntity {
    Class<CrudRepository> repository()

    String message() default "Entity validation error"

    boolean exists() default true

    Class[] groups() default []

    Class[] payload() default []
}