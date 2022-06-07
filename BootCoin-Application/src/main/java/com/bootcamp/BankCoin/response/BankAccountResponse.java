package com.bootcamp.BankCoin.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class BankAccountResponse {

	private String id;

	private String numberAccount;

	private int keyAccount;

	private double availableBalanceAccount;

	@JsonFormat(pattern = "dd-MM-yyyy", timezone = "GMT-05:00")
	private Date dateLastBankAccount;

	private boolean statusAccount;

	private CustomerResponse customer;
}
