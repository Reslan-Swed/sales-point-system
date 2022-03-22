package com.management.salessystem.request


import com.management.salessystem.validator.RequiredAtLeastOne
import com.management.salessystem.validator.group.SecondaryValidator
import groovy.transform.Canonical

import javax.validation.GroupSequence
import javax.validation.constraints.Positive

@Canonical
@RequiredAtLeastOne(message = 'Requires price, quantity or both')
@GroupSequence([UpdateSaleEntryRequest.class, SecondaryValidator.class])
class UpdateSaleEntryRequest implements Serializable {
    @Positive(message = 'Please specify a valid entry price')
    Double price
    @Positive(message = 'Please specify a valid entry quantity')
    Long quantity

    @Override
    String toString() {
        "UpdateSaleEntryRequest{${properties.findAll { key, value -> value != null && key != 'class' }.collect { name, value -> "$name: $value" }.join(',')}}"
    }
}
