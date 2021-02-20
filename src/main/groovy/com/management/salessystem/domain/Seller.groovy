package com.management.salessystem.domain

import groovy.transform.Canonical

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotEmpty

@Canonical
@Entity
@Table(name = 'sellers')
class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @NotEmpty(message = "Please specify seller's name")
    @Column(nullable = false)
    String name
}
