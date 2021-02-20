package com.management.salessystem.repository

import com.management.salessystem.domain.Sale
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleRepository extends CrudRepository<Sale, Long> {
}
