package com.management.salessystem.repository

import com.management.salessystem.domain.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository extends CrudRepository<Product, Long> {

}