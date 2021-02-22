package com.management.salessystem.domain

import groovy.transform.Canonical
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.UpdateTimestamp

import javax.persistence.*

@Canonical
@Entity
@DynamicUpdate
@Table(name = 'products')
class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id
    @Column(nullable = false)
    String name
    @Column
    String description
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = 'create_date')
    Date createDate
    @ManyToOne
    @JoinColumn(name = 'category_id', nullable = false)
    Category category
}
