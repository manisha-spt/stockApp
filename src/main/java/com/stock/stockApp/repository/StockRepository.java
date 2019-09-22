package com.stock.stockApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.stockApp.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	
	Stock findByStockName(String stockName);
	

}
