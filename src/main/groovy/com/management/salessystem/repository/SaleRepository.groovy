package com.management.salessystem.repository

import com.management.salessystem.domain.Sale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository extends JpaRepository<Sale, Long> {
}
