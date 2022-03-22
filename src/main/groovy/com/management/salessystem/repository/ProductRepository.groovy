package com.management.salessystem.repository

import com.management.salessystem.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository extends JpaRepository<Product, Long> {

}