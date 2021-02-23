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
    void createNewSale(CreateSaleRequest request) {
        final seller = sellerRepository.findById(request.sellerId).orElse(null)
        Assert.notNull(seller, "Specified seller with id of ${request.sellerId} not found")
        final client = clientRepository.findById(request.clientId).orElse(null)
        Assert.notNull(seller, "Specified client with id of ${request.clientId} not found")
        final sale = saleRepository.save(new Sale(seller: seller, client: client))
        request.entries.forEach {
            final product = new Product(id: it.productId)
            saleEntryRepository.save(new SaleEntry(sale: sale, product: product, price: it.price, quantity: it.quantity))
        }
    }

    @Logging
    @Override
    void updateExistSaleEntry(Long id, UpdateSaleEntryRequest request) {
        Assert.notNull(id, "Sale's id must be specified")
        final sale = saleRepository.findById(id).orElse(null)
        Assert.notNull(sale, "Specified sale with id of $id not found")
        final oldSaleEntry = saleEntryRepository.findBySaleIdAndProductId(id, request.productId).orElse(null)
        Assert.notNull(oldSaleEntry, "Specified sale entry of product with id of ${request.productId} not found")
        final saleEntry = new SaleEntry(id: oldSaleEntry.id, product: oldSaleEntry.product,
                sale: sale, price: request.price ?: oldSaleEntry.price, quantity: request.quantity ?: oldSaleEntry.quantity)
        saleEntryRepository.save(saleEntry)
    }

    @Override
    List<Sale> getAllSales() {
        saleRepository.findAll().toList()
    }
}
