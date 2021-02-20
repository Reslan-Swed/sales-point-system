package com.management.salessystem.repository

import com.management.salessystem.domain.SaleEntry
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SaleEntryRepository extends CrudRepository<SaleEntry, Long>{

}