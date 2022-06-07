package com.bootcamp.BankCoin.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class BootCoin implements Serializable { 
	
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