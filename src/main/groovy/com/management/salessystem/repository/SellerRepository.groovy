package com.management.salessystem.repository

import com.management.salessystem.domain.Seller
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SellerRepository extends CrudRepository<Seller, Long> {
}
