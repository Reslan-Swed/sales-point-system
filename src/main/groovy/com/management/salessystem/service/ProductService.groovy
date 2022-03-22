package com.management.salessystem.service

import com.management.salessystem.domain.Product
import com.management.salessystem.request.CreateProductRequest
import com.management.salessystem.request.UpdateProductRequest

interface ProductService {
    Product createNewProduct(CreateProductRequest request)

    Product updateExistProduct(Product product, UpdateProductRequest request)

    List<Product> getAllProducts()
}
