package com.stock.stockApp.service;

import com.stock.stockApp.dto.StockResponseDTO;

public interface StockService {

	public StockResponseDTO fetchLatestStockPrice(String stockName);
}
