package com.management.salessystem.domain

import groovy.transform.Canonical

import javax.persistence.*

@Canonical
@Entity
@Table(name = 'categories')
class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id
    @Column(nullable = false)
    String name
}
