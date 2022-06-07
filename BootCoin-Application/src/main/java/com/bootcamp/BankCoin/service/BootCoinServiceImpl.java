package com.bootcamp.BankCoin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.BankCoin.api.client.BankAccountApiClient;
import com.bootcamp.BankCoin.model.BootCoin;
import com.bootcamp.BankCoin.model.BootCoinPurse;
import com.bootcamp.BankCoin.repository.BankCoinRepository; 
import com.bootcamp.BankCoin.response.CustomerResponse; 

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Service 
public class BootCoinServiceImpl implements BootCoinService {
	
	@Autowired
	BankAccountApiClient bankAccountApiClient; 
	
	@Autowired
	BankCoinRepository bankCoinRepository;
	
	@Override
	public String processCreateBootCoinPurse(BootCoin transaction) throws InterruptedException {


		List<CustomerResponse> bankAsociado = new ArrayList<>();
		 
		bankAsociado = this.bankAccountApiClient.getCustomerbyDni(transaction.getNumberDocument());	
		// Al no encontrar el numero de cuenta 
		
					if(bankAsociado.isEmpty()) {

						// Crea un nueva cuenta Yanki
						
						transaction.setBootcoinamount(0.0);
						transaction.setBootcoinstatus(true);  
						transaction.setNumberIDCount(UUID.randomUUID().toString());
						BootCoinPurse bootcoinpurse = this.registerDto(transaction); 
						this.bankCoinRepository.save(bootcoinpurse).subscribe();
						
						log.info("Yanki Register -->" + bootcoinpurse);
						
						return "Proceso Satisfactorio Nueva Cuenta Yanki sin relacion a un BankAccount";

					} else {

						 transaction.setBootcoinamount(0.0); 
						 transaction.setBankrelation(bankAsociado.get(0).getBank().getCode());
						 transaction.setBootcoinstatus(true);  
						 transaction.setNumberIDCount(UUID.randomUUID().toString());
						 BootCoinPurse bootcoinpurse = this.registerDto(transaction); 
						 
						 this.bankCoinRepository.save(bootcoinpurse).subscribe();
						  
						return "Proceso Satisfactorio Nueva Cuenta Yanki relacionado a un BankAccount";
					}
		
	}
	
	public BootCoinPurse registerDto(BootCoin transaction) {

		BootCoinPurse bootcoinpurse = new BootCoinPurse(); 
		
		bootcoinpurse.setId(transaction.getId()); 
		bootcoinpurse.setBootcoinamount(transaction.getBootcoinamount()); 
		bootcoinpurse.setDocumentType(transaction.getDocumentType());
		bootcoinpurse.setNumberDocument(transaction.getNumberDocument()); 
		bootcoinpurse.setPhoneNumber(transaction.getPhoneNumber()); 
		bootcoinpurse.setEmail(transaction.getEmail()); 
		bootcoinpurse.setBootcoinstatus(transaction.isBootcoinstatus()); 
		bootcoinpurse.setBankrelation(transaction.getBankrelation());
		bootcoinpurse.setNumberIDCount(transaction.getNumberIDCount());
		return bootcoinpurse;
	}
	
	public Flux<BootCoinPurse> getBootCoinPurseByIdUnique(String idunique) {
		return bankCoinRepository.findAll().filter(x -> x.getNumberIDCount().equals(idunique));
	}

}