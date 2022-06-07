package com.bootcamp.BankCoin.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.bootcamp.BankCoin.config.Util;
import com.bootcamp.BankCoin.model.BootCoin;
import com.bootcamp.BankCoin.service.BootCoinService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {
	
	@Autowired
	private BootCoinService bootCoinService;

	@KafkaListener(topics = "${kafka.subscribed-topic.name}")
	public void consumeEvent(String message) throws JsonProcessingException, InterruptedException {
		BootCoin bootcoin = Util.OBJECT_MAPPER.readValue(message, BootCoin.class);
		log.info("Message received " + message);
		bootCoinService.processCreateBootCoinPurse(bootcoin);
	}
}