package com.management.salessystem.service

import com.management.salessystem.domain.Product
import com.management.salessystem.domain.Sale
import com.management.salessystem.domain.SaleEntry
import com.management.salessystem.request.CreateSaleRequest
import com.management.salessystem.request.UpdateSaleEntryRequest

interface SaleService {
    Sale createNewSale(CreateSaleRequest request)

    SaleEntry updateExistedSaleEntry(Sale id, Product product, UpdateSaleEntryRequest request)

    List<Sale> getAllSales()
}