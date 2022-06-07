package com.bootcamp.BankCoin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
 
import com.bootcamp.BankCoin.model.BootCoinPurse;

@Repository
public interface BankCoinRepository extends ReactiveMongoRepository<BootCoinPurse, String> {

}