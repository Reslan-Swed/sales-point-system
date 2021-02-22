package com.management.salessystem.request

import com.management.salessystem.validator.RequiredAtLeastOne
import groovy.transform.Canonical

import javax.validation.constraints.Pattern

@Canonical
@RequiredAtLeastOne
class UpdateClientRequest implements Serializable {
    @Pattern(regexp = '^.+$', message = "Client's name can't be blank")
    String name
    @Pattern(regexp = '^.+$', message = "Client's last name can't be blank")
    String lastName
    @Pattern(regexp = '^09\\d{8}$', message = 'Please specify a valid mobile number like 09xxxxxxxx')
    String mobile
}
