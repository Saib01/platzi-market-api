package com.platzi.platzimarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.platzi.platzimarket.domain.Purchase;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);

}
