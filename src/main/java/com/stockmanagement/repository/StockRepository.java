package com.stockmanagement.repository;

import com.stockmanagement.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @created Barnaba Mutai
 * @created 05/ 09/ 2022 - 10:41 AM
 */
public interface StockRepository extends JpaRepository<Stock,Long> {
}
