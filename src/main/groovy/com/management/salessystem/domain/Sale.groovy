package com.management.salessystem.domain


import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.management.salessystem.extra.SaleEntrySerializer
import groovy.transform.Canonical
import org.hibernate.annotations.UpdateTimestamp

import javax.persistence.*

@Canonical
@Entity
@Table(name = 'sales')
class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = 'create_date')
    Date createDate
    @ManyToOne
    @JoinColumn(name = 'seller_id', nullable = false)
    Seller seller
    @ManyToOne
    @JoinColumn(name = 'client_id', nullable = false)
    Client client
    @JsonSerialize(using = SaleEntrySerializer.class)
    @OneToMany(mappedBy = 'sale', cascade = CascadeType.ALL)
    List<SaleEntry> entries = []
    @Transient
    Double total

    @PostLoad
    void calculateTotal() {
        total = entries*.price.sum() as Double
    }
}
