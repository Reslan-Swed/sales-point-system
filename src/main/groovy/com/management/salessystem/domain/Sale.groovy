package com.management.salessystem.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import groovy.transform.Canonical
import org.hibernate.annotations.CreationTimestamp

import javax.persistence.*

@Canonical
@Entity
@Table(name = 'sales')
class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = 'create_date')
    Date createDate
    @ManyToOne
    @JoinColumn(name = 'seller_id', nullable = false)
    Seller seller
    @JsonManagedReference
    @OneToMany(mappedBy = 'sale', cascade = CascadeType.ALL)
    List<SaleEntry> entries
    @Transient
    Double total

    @PostLoad
    def calculateTotal() {
        total = entries*.price.sum() as Double
    }
}
