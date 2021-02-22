package com.management.salessystem.validator


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.data.repository.CrudRepository

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class CheckEntityValidator implements ConstraintValidator<CheckEntity, Object> {
    @Autowired
    private ApplicationContext context

    private Class repository

    private boolean exists

    @Override
    void initialize(CheckEntity constraintAnnotation) {
        repository = constraintAnnotation.repository()
        exists = constraintAnnotation.exists()
    }

    @Override
    boolean isValid(Object target, ConstraintValidatorContext constraintValidatorContext) {
        target == null || !((context?.getBean(repository) as CrudRepository)?.findById(target)?.orElse(null) != null ^ exists)
    }
}
