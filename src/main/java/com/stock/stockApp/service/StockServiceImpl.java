package com.stock.stockApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.stock.stockApp.dto.StockResponseDTO;
import com.stock.stockApp.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;
	@Autowired
	RestTemplate restTemplate;
	
	@SuppressWarnings("unused")
	@Override
	  public StockResponseDTO fetchLatestStockPrice(String stockName) {
	  
	  StockResponseDTO stockResponseDTO = new StockResponseDTO();
	  
		JsonNode response =restTemplate.exchange("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + stockName
				+ "&apikey=JX52QBGWV5X1C7YA", HttpMethod.GET, null, new ParameterizedTypeReference<JsonNode>() { },
				  stockName).getBody();

		Double latestStockPrice = response.get("Global Quote").get("05. price").asDouble();
	
		if(latestStockPrice!=null) {
			stockResponseDTO.setStockPrice(latestStockPrice);
		}else {
			stockResponseDTO.setStockPrice((stockRepository.findByStockName(stockName).getStockPrice()));
		}
	  return stockResponseDTO;
	  }
	
}
