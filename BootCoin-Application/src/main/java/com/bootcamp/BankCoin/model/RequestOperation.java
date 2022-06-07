package com.bootcamp.BankCoin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "requestOperationBootCoin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestOperation {
	
	@Id
	private String id; 
	
	private String codeOperation;
	
	// COIN para el monedero
	private Integer amountcoin;
	
	private Double conversiontasa;
	
	// Monto en la cual va a recibir por la compra o venta
	private Double amountconvert;
	  
	private boolean statusoperation;   
	 
	private String requestorigen;
	
	private String requestdestination;
	
	// Descuento o deposito de la cuenta 
	private String accountcoinDestination;
	
	// Venta - Compra
	private String payType;
	
	private String payMode;
	
	private String accountDestinationcoin;
}

