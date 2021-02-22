package com.management.salessystem.request

import com.management.salessystem.repository.ProductRepository
import com.management.salessystem.repository.SellerRepository
import com.management.salessystem.validator.CheckEntity
import com.management.salessystem.validator.group.SecondaryValidator
import groovy.transform.Canonical

import javax.validation.GroupSequence
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive
import javax.validation.constraints.PositiveOrZero

@Canonical
@GroupSequence([CreateSaleRequest.class, SecondaryValidator.class])
class CreateSaleRequest implements Serializable {
    @NotNull(message = "Please specify seller's id")
    @PositiveOrZero(message = "Seller's id must be a valid positive number or zero")
    @CheckEntity(repository = SellerRepository.class, message = "Seller's id not exist", groups = SecondaryValidator.class)
    Long sellerId
    @Valid
    @NotEmpty(message = "Please specify sale's entries list")
    List<ProductItem> entries

    @Canonical
    @GroupSequence([ProductItem.class, SecondaryValidator.class])
    static class ProductItem implements Serializable {
        @NotNull(message = "Please specify product's id")
        @PositiveOrZero(message = "Product's id must be a valid positive number or zero")
        @CheckEntity(repository = ProductRepository.class, message = "Product's id not exist", groups = SecondaryValidator.class)
        Long productId
        @NotNull(message = "Please specify entry's price")
        @Positive(message = 'Please specify a valid entry price')
        Double price
        @NotNull(message = "Please specify entry's quantity")
        @Positive(message = 'Please specify a valid entry quantity')
        Long quantity
    }
}
