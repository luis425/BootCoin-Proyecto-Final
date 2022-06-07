package com.bootcamp.BankCoin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.bootcamp.BankCoin.response.Bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Document
@Data
@Builder
public class BankTasa {
	
	@Id
	private String id;
	 
	private Double tasaventa;
	
	private Double tasacompra;
	
	private Bank bank;
	
}

