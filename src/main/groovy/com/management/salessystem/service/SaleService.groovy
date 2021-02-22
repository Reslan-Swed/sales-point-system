package com.management.salessystem.service

import com.management.salessystem.domain.Sale
import com.management.salessystem.request.CreateSaleRequest
import com.management.salessystem.request.UpdateSaleEntryRequest

interface SaleService {
    void createNewSale(CreateSaleRequest request)

    void updateExistSaleEntry(Long id, UpdateSaleEntryRequest request)

    List<Sale> getAllSales()
}