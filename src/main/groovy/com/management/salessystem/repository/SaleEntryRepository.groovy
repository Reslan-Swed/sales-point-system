package com.management.salessystem.repository

import com.management.salessystem.domain.SaleEntry
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface SaleEntryRepository extends CrudRepository<SaleEntry, Long> {
    @Query('SELECT s FROM SaleEntry s WHERE s.sale.id = :saleId AND s.product.id = :productId')
    Optional<SaleEntry> findBySaleIdAndProductId(@Param('saleId') Long saleId, @Param('productId') Long productId)
}