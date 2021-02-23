package com.management.salessystem.request

import com.management.salessystem.repository.ProductRepository
import com.management.salessystem.validator.CheckEntity
import com.management.salessystem.validator.RequiredAtLeastOne
import com.management.salessystem.validator.group.SecondaryValidator
import groovy.transform.Canonical

import javax.validation.GroupSequence
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.PositiveOrZero

@Canonical
@RequiredAtLeastOne(skip = 'productId', message = 'Requires price, quantity or both')
@GroupSequence([UpdateSaleEntryRequest.class, SecondaryValidator.class])
class UpdateSaleEntryRequest implements Serializable {
    @NotNull(message = "Please specify product's id")
    @PositiveOrZero(message = "Product's id must be a valid positive number or zero")
    @CheckEntity(repository = ProductRepository.class, message = "Product's id not exist", groups = SecondaryValidator.class)
    Long productId
    @Positive(message = 'Please specify a valid entry price')
    Double price
    @Positive(message = 'Please specify a valid entry quantity')
    Long quantity

    @Override
    String toString() {
        "UpdateSaleEntryRequest{${properties.findAll { key, value -> value != null && key != 'class' }.collect { name, value -> "$name: $value" }.join(',')}}"
    }
}
