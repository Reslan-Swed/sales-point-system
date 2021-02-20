package com.management.salessystem.domain


import groovy.transform.Canonical

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Canonical
@Entity
@Table(name = 'categories')
class Category implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id
    @NotEmpty(message = "Please specify category's name")
    @Column(nullable = false, unique = true)
    String name
}
