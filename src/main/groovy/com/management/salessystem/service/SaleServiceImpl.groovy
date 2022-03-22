package com.management.salessystem.service

import com.management.salessystem.aop.Logging
import com.management.salessystem.domain.Product
import com.management.salessystem.domain.Sale
import com.management.salessystem.domain.SaleEntry
import com.management.salessystem.repository.ClientRepository
import com.management.salessystem.repository.SaleEntryRepository
import com.management.salessystem.repository.SaleRepository
import com.management.salessystem.repository.SellerRepository
import com.management.salessystem.request.CreateSaleRequest
import com.management.salessystem.request.UpdateSaleEntryRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.Assert

@Service
class SaleServiceImpl implements SaleService {
    private SaleRepository saleRepository

    private SaleEntryRepository saleEntryRepository

    private SellerRepository sellerRepository

    private ClientRepository clientRepository

    SaleServiceImpl(SaleRepository saleRepository, SaleEntryRepository saleEntryRepository, SellerRepository sellerRepository, ClientRepository clientRepository) {
        this.saleRepository = saleRepository
        this.saleEntryRepository = saleEntryRepository
        this.sellerRepository = sellerRepository
        this.clientRepository = clientRepository
    }

    @Transactional
    @Override
    Sale createNewSale(CreateSaleRequest request) {
        final seller = sellerRepository.findById(request.sellerId).orElse(null)
        Assert.notNull(seller, "Specified seller with id of ${request.sellerId} not found")
        final client = clientRepository.findById(request.clientId).orElse(null)
        Assert.notNull(client, "Specified client with id of ${request.clientId} not found")
        saleRepository.saveAndFlush(new Sale(seller: seller, client: client)).tap {
            sale -> request.entries.forEach {
                final product = new Product(id: it.productId)
                sale.entries.push(new SaleEntry(sale: sale, product: product, price: it.price, quantity: it.quantity))
            }
        }
    }

    @Logging
    @Override
    SaleEntry updateExistedSaleEntry(Sale sale, Product product, UpdateSaleEntryRequest request) {
        final saleEntry = saleEntryRepository.findBySaleAndProduct(sale, product).orElse(null)
        Assert.notNull(saleEntry, "Specified sale entry of product with id of ${request.productId} not found")
        saleEntry.tap {
            price = request.price ?: price
            quantity = request.quantity ?: quantity
            saleEntryRepository.save(it)
        }
    }

    @Override
    List<Sale> getAllSales() {
        saleRepository.findAll().toList()
    }
}
