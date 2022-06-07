package com.bootcamp.BankCoin.model;
 

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class YankiAccount { 
	
	private String id;  
	
	private boolean yunkiAccountstatus;
	
	private Double amount;  
	 
	private String documentType;
	
	private String numberDocument;
	
	private String phoneNumber;
	
	private String imei;
	
	private String email;
	
	private String numberDebitCard; 
	
}