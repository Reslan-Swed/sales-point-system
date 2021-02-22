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
    void createNewProduct(CreateProductRequest request) {
        final category = checkCategory(request.categoryId)
        final product = new Product(name: request.name, description: request.description, category: category)
        productRepository.save(product)
    }

    @Override
    void updateExistProduct(Long id, UpdateProductRequest request) {
        Assert.notNull(id, "Product's id must be specified")
        final oldProduct = productRepository.findById(id).orElse(null)
        Assert.notNull(oldProduct, "Specified product with id of $id not found")
        final category = request.categoryId != null ? checkCategory(request.categoryId) : null
        final product = new Product(id: id, name: request.name ?: oldProduct.name,
                description: request.description ?: oldProduct.description, category: category ?: oldProduct.category)
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
