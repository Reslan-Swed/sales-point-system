package com.management.salessystem.service

import com.management.salessystem.domain.Product
import com.management.salessystem.request.CreateProductRequest
import com.management.salessystem.request.UpdateProductRequest

interface ProductService {
    void createNewProduct(CreateProductRequest request)

    void updateExistProduct(Long id, UpdateProductRequest request)

    List<Product> getAllProducts()
}
