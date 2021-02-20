package com.management.salessystem.service

import com.management.salessystem.domain.Product
import com.management.salessystem.repository.CategoryRepository
import com.management.salessystem.repository.ProductRepository
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
    Product createNewProduct(Product product) {
        Assert.notNull(product, 'Product must be specified')
        Assert.notNull(product.category?.id, 'Category id must be specified')
        Assert.notNull(categoryRepository.findById(product.category.id).orElse(null), "Specified category with id of $id not found")
        productRepository.save(product)
    }

    @Override
    Product updateExistProduct(Long id, Product replacementProduct) {
        Assert.notNull(id, "Product id must be specified")
        Assert.notNull(replacementProduct, "Replacement product must be specified")
        Assert.notNull(productRepository.findById(id).orElse(null), "Specified product with id of $id not found")
        Assert.notNull(replacementProduct.category?.id, 'Category id must be specified')
        Assert.notNull(categoryRepository.findById(replacementProduct.category.id).orElse(null), "Specified category with id of ${replacementProduct.category.id} not found")
        final newProduct = new Product(id: id, name: replacementProduct.name, description: replacementProduct.description,
                category: replacementProduct.category)
        productRepository.save(newProduct)
    }

    @Override
    List<Product> getAllProducts() {
        productRepository.findAll().toList()
    }
}
