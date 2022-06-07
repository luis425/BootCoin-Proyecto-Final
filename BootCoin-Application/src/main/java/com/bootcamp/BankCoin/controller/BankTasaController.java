package com.bootcamp.BankCoin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bootcamp.BankCoin.api.client.BankAccountApiClient;
import com.bootcamp.BankCoin.model.BankTasa; 
import com.bootcamp.BankCoin.response.Bank;
import com.bootcamp.BankCoin.service.BankTasaService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/bankTasa")
public class BankTasaController {

	@Autowired
	BankTasaService bankTasaService;
	
	@Autowired
	BankAccountApiClient bankAccountApiClient; 
	
	@PostMapping
	public Mono<BankTasa> createBankTasa(@RequestBody BankTasa bankTasa) {
 

			try {

				Bank bank = this.bankAccountApiClient.comunicationWebClientBankbyCode(bankTasa.getBank().getCode());  
				
				long temporizador = (2 * 1000);
				Thread.sleep(temporizador);

				log.info("Obtener valor para validar Id --->" + bank); 

				if (bank == null) {
					return Mono.error(new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
							"El codigo Banco enviado no existe."));
				} else {
					bankTasa.setBank(bank);
					return this.bankTasaService.createBankTasa(bankTasa);
				}

			} catch (InterruptedException e) {
				log.info(e.toString());
				Thread.currentThread().interrupt();
				return Mono.error(new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage()));
			}
 

	}
}
