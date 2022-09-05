package com.stockmanagement.service;

import com.stockmanagement.payload.StockDTO;
import com.stockmanagement.payload.StockResponse;


/**
 * @created Barnaba Mutai
 * @created 05/ 09/ 2022 - 9:33 AM
 */
public interface StockService {

     StockDTO createStock(StockDTO stockDTO) ;

     StockResponse getAllStocks(int pageNo, int pageSize, String sortBy, String sortDir);

     StockDTO getStockById(long id);

     StockDTO updateStock(StockDTO stockDTO, long id);

     void deleteStockById (long id);

     StockDTO getStockByUserId(long userid);


}
