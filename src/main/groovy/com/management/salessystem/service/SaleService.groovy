package com.management.salessystem.service

import com.management.salessystem.domain.Sale
import com.management.salessystem.domain.SaleEntry
import com.management.salessystem.domain.Seller

interface SaleService {
    Sale createNewSale(Seller seller, List<SaleEntry> entries)

    Sale updateExistSaleEntry(Long id, SaleEntry replacementSaleEntry)

    List<Sale> getAllSales()
}