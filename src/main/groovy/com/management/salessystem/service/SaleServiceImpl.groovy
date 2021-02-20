package com.management.salessystem.service

import com.management.salessystem.domain.Sale
import com.management.salessystem.domain.SaleEntry
import com.management.salessystem.domain.Seller
import com.management.salessystem.repository.SaleEntryRepository
import com.management.salessystem.repository.SaleRepository
import com.management.salessystem.repository.SellerRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.Assert

@Service
class SaleServiceImpl implements SaleService {
    private SaleRepository saleRepository

    private SaleEntryRepository saleEntryRepository

    private SellerRepository sellerRepository

    SaleServiceImpl(SaleRepository saleRepository, SaleEntryRepository saleEntryRepository, SellerRepository sellerRepository) {
        this.saleRepository = saleRepository
        this.saleEntryRepository = saleEntryRepository
        this.sellerRepository = sellerRepository
    }

    @Transactional
    @Override
    Sale createNewSale(Seller seller, List<SaleEntry> entries) {
        Assert.notNull(entries, 'Sale entries must be specified')
        Assert.notNull(seller?.id, 'Seller id must be specified')
        Assert.notNull(sellerRepository.findById(seller.id).orElse(null), "Specified seller with id of ${seller.id} not found")
        final sale = new Sale(seller: seller, entries: entries)
        saleRepository.save(sale)
    }

    @Override
    Sale updateExistSaleEntry(Long id, SaleEntry replacementSaleEntry) {
        Assert.notNull(replacementSaleEntry, 'Replacement sale entry must be specified')
        Assert.notNull(saleEntryRepository.findById(id).orElse(null), "Specified entry with id of $id not found")
        Assert.notNull(replacementSaleEntry?.sale, 'Sale id must be specified')
        Assert.notNull(saleRepository.findById(replacementSaleEntry.sale.id).orElse(null), "Specified sale with id of ${replacementSaleEntry.sale.id} not found")
        final newSaleEntry = new SaleEntry(id: id, product: replacementSaleEntry.product, sale: replacementSaleEntry.sale, price: replacementSaleEntry.price, quantity: replacementSaleEntry.quantity)
        saleEntryRepository.save(newSaleEntry)
        saleRepository.findById(replacementSaleEntry.sale.id).orElseThrow()
    }

    @Override
    List<Sale> getAllSales() {
        saleRepository.findAll().toList()
    }
}
