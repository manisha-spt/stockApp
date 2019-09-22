package com.stock.stockApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stock.stockApp.dto.StockResponseDTO;
import com.stock.stockApp.service.StockService;

@RestController
@RequestMapping("/stockApp")
public class StockController {

	@Autowired
	StockService stockService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/stock/{stockName}")
//	public Double getStockPrice(@PathVariable String stockName)
	public ResponseEntity<StockResponseDTO> getStockPrice(@PathVariable String stockName)
	{
		StockResponseDTO latestStockPrice = stockService.fetchLatestStockPrice(stockName);

		  return new ResponseEntity<>(latestStockPrice, HttpStatus.OK);
		
	}
	
	
	  @Bean
//	  @LoadBalanced 
	  public RestTemplate restTemplate() { 
		  return new RestTemplate();
	  }
	 
}
