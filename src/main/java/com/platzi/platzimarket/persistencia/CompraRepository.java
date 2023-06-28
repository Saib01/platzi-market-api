package com.platzi.platzimarket.persistencia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.platzi.platzimarket.domain.Purchase;
import com.platzi.platzimarket.domain.repository.PurchaseRepository;
import com.platzi.platzimarket.persistencia.crud.CompraCrudRepository;
import com.platzi.platzimarket.persistencia.entity.Compra;
import com.platzi.platzimarket.persistencia.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseRepository{
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;
    

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(compras ->mapper.toPurchases(compras) );
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra=mapper.toCompra(purchase);
        compra.getProductos().forEach(producto->producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
    
}
