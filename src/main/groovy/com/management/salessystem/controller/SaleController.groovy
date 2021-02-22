package com.management.salessystem.controller


import com.management.salessystem.domain.Sale
import com.management.salessystem.request.CreateSaleRequest
import com.management.salessystem.request.UpdateSaleEntryRequest
import com.management.salessystem.response.SuccessResponse
import com.management.salessystem.service.SaleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/sales")
class SaleController {
    private SaleService saleService

    SaleController(SaleService saleService) {
        this.saleService = saleService
    }

    @GetMapping
    List<Sale> index() {
        saleService.getAllSales()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SuccessResponse store(@Valid @RequestBody CreateSaleRequest request) {
        saleService.createNewSale(request)
        new SuccessResponse(message: 'Sale created successfully')
    }

    @PutMapping('/{id}')
    @ResponseStatus(HttpStatus.OK)
    SuccessResponse update(@PathVariable('id') Long id, @Valid @RequestBody UpdateSaleEntryRequest request) {
        saleService.updateExistSaleEntry(id, request)
        new SuccessResponse(message: 'Sale entry updated successfully')
    }
}
