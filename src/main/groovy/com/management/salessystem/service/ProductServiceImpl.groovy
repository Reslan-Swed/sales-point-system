package com.management.salessystem.service

import com.management.salessystem.domain.Category
import com.management.salessystem.domain.Product
import com.management.salessystem.repository.CategoryRepository
import com.management.salessystem.repository.ProductRepository
import com.management.salessystem.request.CreateProductRequest
import com.management.salessystem.request.UpdateProductRequest
import org.springframework.stereotype.Service
import org.springframework.util.Assert

@Service
class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository

    private CategoryRepository categoryRepository

    ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository
        this.categoryRepository = categoryRepository
    }

    @Override
    Product createNewProduct(CreateProductRequest request) {
        final category = checkCategory(request.categoryId)
        new Product(name: request.name, description: request.description, category: category).with {
            productRepository.save(it)
        }
    }

    @Override
    Product updateExistProduct(Product product, UpdateProductRequest request) {
        final newCategory = request.categoryId != null ? checkCategory(request.categoryId) : null
        product.tap {
            name = request.name ?: name
            description = request.description ?: description
            category = newCategory ?: category
        }
        productRepository.save(product)
    }

    @Override
    List<Product> getAllProducts() {
        productRepository.findAll().toList()
    }

    private Category checkCategory(Long id) {
        final category = categoryRepository.findById(id).orElse(null)
        Assert.notNull(category, "Specified category with id of $id not found")
        category
    }
}
