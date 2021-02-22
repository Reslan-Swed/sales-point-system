package com.management.salessystem.validator

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class RequiredAtLeastOneValidator implements ConstraintValidator<RequiredAtLeastOne, Object> {
    private List<String> skipFields

    @Override
    void initialize(RequiredAtLeastOne constraintAnnotation) {
        skipFields = constraintAnnotation.skip()
        skipFields.push('class')
    }

    @Override
    boolean isValid(Object target, ConstraintValidatorContext constraintValidatorContext) {
        target.properties.any { name, value -> !skipFields.contains(name) && value != null }
    }
}
