package com.bootcamp.BankCoin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
 
import com.bootcamp.BankCoin.model.RequestOperation;

@Repository
public interface RequestOperationRepository extends ReactiveMongoRepository<RequestOperation, String> { 
}
