package com.management.salessystem.validator

import javax.validation.Constraint
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RequiredAtLeastOneValidator.class)
@interface RequiredAtLeastOne {
    String message() default "Requires at least one field"

    String[] skip() default []

    Class[] groups() default []

    Class[] payload() default []
}