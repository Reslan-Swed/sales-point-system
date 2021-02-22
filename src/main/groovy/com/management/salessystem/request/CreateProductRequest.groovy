package com.management.salessystem.request

import com.management.salessystem.repository.CategoryRepository
import com.management.salessystem.validator.CheckEntity
import com.management.salessystem.validator.group.SecondaryValidator
import groovy.transform.Canonical

import javax.validation.GroupSequence
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.PositiveOrZero

@Canonical
@GroupSequence([CreateProductRequest.class, SecondaryValidator.class])
class CreateProductRequest implements Serializable {
    @NotEmpty(message = "Please specify product's name")
    String name
    @Pattern(regexp = '^.+$', message = "Product's description can't be blank")
    String description
    @NotNull(message = "Please specify category's id")
    @PositiveOrZero(message = "Category's id must be a valid positive number or zero")
    @CheckEntity(repository = CategoryRepository.class, message = "Category's id not exist", groups = SecondaryValidator.class)
    Long categoryId
}
