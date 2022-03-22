package com.management.salessystem.controller

import com.management.salessystem.domain.Product
import com.management.salessystem.request.CreateProductRequest
import com.management.salessystem.request.UpdateProductRequest
import com.management.salessystem.response.SuccessResponse
import com.management.salessystem.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/products")
class ProductController {
    private ProductService productService

    ProductController(ProductService productService) {
        this.productService = productService
    }

    @GetMapping
    SuccessResponse index() {
        productService.getAllProducts().with {
            new SuccessResponse(data: it)
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SuccessResponse store(@Valid @RequestBody CreateProductRequest request) {
        productService.createNewProduct(request).with {
            new SuccessResponse(message: 'Product created successfully', data: it)
        }
    }

    @PutMapping('/{id}')
    SuccessResponse update(@PathVariable('id') Product product, @Valid @RequestBody UpdateProductRequest request) {
        productService.updateExistProduct(product, request).with {
            new SuccessResponse(message: 'Product updated successfully', data: it)
        }
    }
}
