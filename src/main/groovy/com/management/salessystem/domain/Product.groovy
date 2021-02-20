package com.management.salessystem.domain

import groovy.transform.Canonical
import org.hibernate.annotations.CreationTimestamp

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Canonical
@Entity
@Table(name = 'products')
class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id
    @NotEmpty(message = "Please specify product's name")
    @Column(nullable = false, unique = true)
    String name
    @Column
    String description
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = 'create_date', nullable = false)
    Date createDate
    @ManyToOne
    @JoinColumn(name = 'category_id', nullable = false)
    Category category
}
