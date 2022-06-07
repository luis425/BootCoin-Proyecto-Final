package com.bootcamp.BankCoin.service;

import com.bootcamp.BankCoin.model.BootCoin;
import com.bootcamp.BankCoin.model.BootCoinPurse;

import reactor.core.publisher.Flux;

public interface BootCoinService {
	
	// Crear monedero BootCoin 
	
	String processCreateBootCoinPurse(BootCoin transaction) throws InterruptedException; 
	
	Flux<BootCoinPurse> getBootCoinPurseByIdUnique(String idunique);

}
