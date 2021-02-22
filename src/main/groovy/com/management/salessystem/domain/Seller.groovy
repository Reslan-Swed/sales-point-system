package com.management.salessystem.domain

import groovy.transform.Canonical

import javax.persistence.*

@Canonical
@Entity
@Table(name = 'sellers')
class Seller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @Column(nullable = false)
    String name
}
