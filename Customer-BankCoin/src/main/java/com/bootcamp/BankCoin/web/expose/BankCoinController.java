package com.bootcamp.BankCoin.web.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.BankCoin.producer.KafkaProducer;

@RestController
public class BankCoinController {
	
	@Autowired
	private KafkaProducer kafkaProducer;

	@PostMapping("/customer/bankcoin")
	public ResponseEntity<String> requestYanki(@RequestBody String bankcoin) {
		kafkaProducer.publishMessage(bankcoin);
		return ResponseEntity.ok(bankcoin);
	}

}