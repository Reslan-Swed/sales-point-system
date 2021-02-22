package com.management.salessystem.domain

import groovy.transform.Canonical
import org.hibernate.annotations.DynamicUpdate

import javax.persistence.*

@Canonical
@Entity
@DynamicUpdate
@Table(name = 'clients')
class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id
    @Column(nullable = false)
    String name
    @Column(nullable = false)
    String lastName
    @Column(nullable = false)
    String mobile
}
