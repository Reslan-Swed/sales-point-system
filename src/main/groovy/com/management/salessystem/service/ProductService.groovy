package com.management.salessystem.service

import com.management.salessystem.domain.Product

interface ProductService {
    Product createNewProduct(Product product)

    Product updateExistProduct(Long id, Product replacementProduct)

    List<Product> getAllProducts()
}
