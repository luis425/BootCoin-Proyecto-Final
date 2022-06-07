package com.bootcamp.BankCoin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.BankCoin.model.BankTasa; 

@Repository
public interface BankTasaRepository extends ReactiveMongoRepository<BankTasa, String> {

}
