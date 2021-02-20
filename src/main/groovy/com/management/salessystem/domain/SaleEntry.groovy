package com.management.salessystem.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import groovy.transform.Canonical

import javax.persistence.*
import javax.validation.constraints.Pattern

@Canonical
@Entity
@Table(name = 'sale_entries')
class SaleEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @ManyToOne
    @JoinColumn(name = 'product_id', nullable = false)
    Product product
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = 'sale_id', nullable = false)
    Sale sale
    @Pattern(regexp = '^[1-9]\\d*$', message = 'Please specify a valid price')
    @Column(nullable = false)
    Double price
    @Pattern(regexp = '^[1-9]\\d*$', message = 'Please specify a valid quantity')
    @Column(nullable = false)
    Long quantity
}
