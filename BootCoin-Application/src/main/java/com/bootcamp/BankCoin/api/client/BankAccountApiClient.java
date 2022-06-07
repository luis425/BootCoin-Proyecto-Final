package com.bootcamp.BankCoin.api.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.bootcamp.BankCoin.config.BankAccountApiProperties;
import com.bootcamp.BankCoin.config.BankApiProperties;
import com.bootcamp.BankCoin.config.CustomerApiProperties;
import com.bootcamp.BankCoin.config.YankiApiProperties;
import com.bootcamp.BankCoin.model.YankiAccount;
import com.bootcamp.BankCoin.response.Bank;
import com.bootcamp.BankCoin.response.BankAccountResponse;
import com.bootcamp.BankCoin.response.BankAccounts;
import com.bootcamp.BankCoin.response.CustomerResponse;
import com.bootcamp.BankCoin.response.DebitCardResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.scheduler.Schedulers;

@Slf4j
@Component
@RequiredArgsConstructor
public class BankAccountApiClient {

	private final WebClient webClient;
	
	private final BankAccountApiProperties bankAccountApiProperties;
	
	private final CustomerApiProperties customerApiProperties;
	
	private final YankiApiProperties yankiApiProperties;
	
	private final BankApiProperties bankApiProperties;
	
	public List<BankAccountResponse> getBankAccountbyNumberAccount(String numberAccount) throws InterruptedException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<BankAccountResponse> result = new ArrayList<>();
		webClient.get().uri(bankAccountApiProperties.getBaseUrl() + "/bankAccounts/BankAccountResponse/".concat(numberAccount))
				.accept(MediaType.TEXT_EVENT_STREAM).retrieve().bodyToFlux(BankAccountResponse.class)
				.publishOn(Schedulers.fromExecutor(executor))
				.subscribe(assuranceResponse -> result.add(assuranceResponse));

		executor.awaitTermination(3, TimeUnit.SECONDS);
		log.info("Assurance list " + result);
		return result;
	}
	
	public List<DebitCardResponse> getDebitCardbyCustomerNumberCreditCard(String numberDebitCard) throws InterruptedException {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<DebitCardResponse> result = new ArrayList<>();
		webClient.get().uri(bankAccountApiProperties.getBaseUrl() + "/debitCard/debitCardbydniResponse/".concat(numberDebitCard))
				.accept(MediaType.TEXT_EVENT_STREAM).retrieve().bodyToFlux(DebitCardResponse.class)
				.publishOn(Schedulers.fromExecutor(executor))
				.subscribe(debitcard -> result.add(debitcard));

		executor.awaitTermination(6, TimeUnit.SECONDS);
		log.info("Assurance list " + result);
		return result;
	}
	
	public List<CustomerResponse> getCustomerbyDni(String dni) throws InterruptedException {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<CustomerResponse> result = new ArrayList<>();
		webClient.get().uri(customerApiProperties.getBaseUrl() + "/customer/customerbydniResponse/".concat(dni))
				.accept(MediaType.TEXT_EVENT_STREAM).retrieve().bodyToFlux(CustomerResponse.class)
				.publishOn(Schedulers.fromExecutor(executor))
				.subscribe(debitcard -> result.add(debitcard));

		executor.awaitTermination(8, TimeUnit.SECONDS);
		log.info("Assurance list " + result);
		return result;
	}
	
	public List<YankiAccount> getYankiAccountbyPhoneNumber(String phonenumber) throws InterruptedException {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<YankiAccount> result = new ArrayList<>();
		webClient.get().uri(yankiApiProperties.getBaseUrl() + "/yankiTransfer/yankibyphone/".concat(phonenumber))
				.accept(MediaType.TEXT_EVENT_STREAM).retrieve().bodyToFlux(YankiAccount.class)
				.publishOn(Schedulers.fromExecutor(executor))
				.subscribe(debitcard -> result.add(debitcard));

		executor.awaitTermination(8, TimeUnit.SECONDS);
		log.info("Assurance list " + result);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public YankiAccount comunicationWebClientYankibyphonenumber(String phonenumber) { 
		String uri = yankiApiProperties.getBaseUrl() + "/yankiTransfer/yankibyphone/".concat(phonenumber);
		RestTemplate restTemplate = new RestTemplate();
		YankiAccount result = restTemplate.getForObject(uri, YankiAccount.class); 
		log.info("Ver lista --->" + result);
		return result;

	}
	
	@SuppressWarnings("unchecked")
	public Bank comunicationWebClientBankbyCode(String code) { 
		String uri = bankApiProperties.getBaseUrl() + "/bank/".concat(code);
		RestTemplate restTemplate = new RestTemplate();
		Bank result = restTemplate.getForObject(uri, Bank.class); 
		log.info("Ver lista --->" + result);
		return result;

	}
	
	@SuppressWarnings("unchecked")
	public BankAccountResponse comunicationWebClientBankAccountbyNumberAccount(String numberaccount) { 
		String uri = bankAccountApiProperties.getBaseUrl() + "/bankAccounts/bankAccountbyNumberAccountResponse/".concat(numberaccount);
		RestTemplate restTemplate = new RestTemplate();
		BankAccountResponse result = restTemplate.getForObject(uri, BankAccountResponse.class); 
		log.info("Ver lista --->" + result);
		return result;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<YankiAccount> comunicationWebClientYankiAccount(YankiAccount yankiaccount) { 
		String uri = yankiApiProperties.getBaseUrl() + "/yankiAccountAct";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<YankiAccount> result = restTemplate.postForEntity(uri, yankiaccount, YankiAccount.class); 
		log.info("Ver lista --->" + result);
		return result;

	}
	
}
