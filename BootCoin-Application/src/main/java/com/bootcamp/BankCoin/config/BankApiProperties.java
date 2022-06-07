package com.bootcamp.BankCoin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "bank-api")
public class BankApiProperties {
	private String baseUrl;
}
