package com.bootcamp.BankCoin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.BankCoin.model.BankTasa; 
import com.bootcamp.BankCoin.repository.BankTasaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankTasaService {

	@Autowired
	BankTasaRepository bankTasaRepository;
	
	public Mono<BankTasa> createBankTasa(BankTasa bankTasa) {
		return bankTasaRepository.save(bankTasa);
	}
	
	public Flux<BankTasa> bankTasabycodebank(String code) {
		return bankTasaRepository.findAll().filter(x -> x.getBank().getCode().equals(code));
	}
}
