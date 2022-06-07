package com.bootcamp.BankCoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.BankCoin.model.RequestOperation;
import com.bootcamp.BankCoin.repository.RequestOperationRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RequestOperationService {

	@Autowired
	RequestOperationRepository requestOperationRepository;
	
	public Mono<RequestOperation> createRequestOperation(RequestOperation requestOperation) {
		return requestOperationRepository.save(requestOperation);
	} 
	
	public Flux<RequestOperation> getRequestOperationById(String id) {
		return requestOperationRepository.findAll().filter(x -> x.getId().equals(id));
	}
}
