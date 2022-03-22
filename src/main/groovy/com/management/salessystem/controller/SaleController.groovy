package com.management.salessystem.controller

import com.management.salessystem.domain.Product
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
    SuccessResponse index() {
        saleService.getAllSales().with {
            new SuccessResponse(data: it)
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SuccessResponse store(@Valid @RequestBody CreateSaleRequest request) {
        saleService.createNewSale(request).with {
            new SuccessResponse(message: 'Sale created successfully', data: it)
        }
    }

    @PutMapping('/{id}/products/{productId}')
    @ResponseStatus(HttpStatus.OK)
    SuccessResponse update(@PathVariable('id') Sale sale, @PathVariable('productId') Product product, @Valid @RequestBody UpdateSaleEntryRequest request) {
        saleService.updateExistedSaleEntry(sale, product, request).with {
            new SuccessResponse(message: 'Sale entry updated successfully', data: it)
        }
    }
}
