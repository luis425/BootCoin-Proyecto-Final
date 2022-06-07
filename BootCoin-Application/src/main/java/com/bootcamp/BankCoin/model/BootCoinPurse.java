package com.bootcamp.BankCoin.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "bootcoinPurse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BootCoinPurse {
	
	private String id;  
	private Double bootcoinamount;
	private String documentType;
	private String numberDocument;
	private String phoneNumber; 
	private String email; 
	private boolean bootcoinstatus;   
	private String bankrelation; 
	private String numberIDCount;
	
}
