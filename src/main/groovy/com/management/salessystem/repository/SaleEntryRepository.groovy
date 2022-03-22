package com.management.salessystem.repository

import com.management.salessystem.domain.Product
import com.management.salessystem.domain.Sale
import com.management.salessystem.domain.SaleEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleEntryRepository extends JpaRepository<SaleEntry, Long> {
    Optional<SaleEntry> findBySaleAndProduct(Sale sale, Product product)
}