package com.management.salessystem.domain

import groovy.transform.Canonical

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern

@Canonical
@Entity
@Table(name = 'clients')
class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id
    @NotEmpty(message = "Please specify client's name")
    @Column(nullable = false)
    String name
    @NotEmpty(message = "Please specify client's last name")
    @Column(nullable = false)
    String lastName
    @Pattern(regexp = '^09\\d{8}$', message = 'Please specify a valid mobile number like 09xxxxxxxx')
    @Column(nullable = false, unique = true)
    String mobile
}
