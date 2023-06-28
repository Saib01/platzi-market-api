package com.platzi.platzimarket.persistencia.crud;

import org.springframework.data.repository.CrudRepository;

import com.platzi.platzimarket.persistencia.entity.Compra;
import java.util.List;
import java.util.Optional;


public interface CompraCrudRepository extends CrudRepository<Compra,Integer>{
    Optional <List<Compra>> findByIdCliente(String idCliente);
    
}
