package com.management.salessystem.request

import groovy.transform.Canonical

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

@Canonical
class CreateClientRequest implements Serializable {
    @NotEmpty(message = "Please specify client's name")
    String name
    @NotEmpty(message = "Please specify client's last name")
    String lastName
    @NotEmpty(message = "Please specify client's mobile")
    @Pattern(regexp = '^09\\d{8}$', message = 'Please specify a valid mobile number like 09xxxxxxxx')
    String mobile
}
