package com.management.salessystem.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import groovy.transform.Canonical
import org.hibernate.annotations.DynamicUpdate

import javax.persistence.*

@Canonical
@Entity
@DynamicUpdate
@Table(name = 'sale_entries')
class SaleEntry implements Serializable {
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
    @Column(nullable = false)
    Double price
    @Column(nullable = false)
    Long quantity
}
