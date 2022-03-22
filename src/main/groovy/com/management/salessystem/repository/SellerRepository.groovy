package com.management.salessystem.repository

import com.management.salessystem.domain.Seller
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SellerRepository extends JpaRepository<Seller, Long> {
}
