package com.stockmanagement.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockmanagement.exception.ResourceNotFoundException;
import com.stockmanagement.model.Stock;
import com.stockmanagement.payload.StockDTO;
import com.stockmanagement.payload.StockResponse;
import com.stockmanagement.payload.User;
import com.stockmanagement.repository.StockRepository;
import com.stockmanagement.service.StockService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @created Barnaba Mutai
 * @created 05/ 09/ 2022 - 10:29 AM
 */
@Service
public class StockServiceImpl implements StockService {
    private StockRepository stockRepository;
    private ObjectMapper mapper;


    public StockServiceImpl(StockRepository stockRepository, ObjectMapper mapper) {

        this.stockRepository = stockRepository;
        this.mapper=mapper;
    }
    @Override
    public StockDTO createStock(StockDTO stockDTO) {
        //Convert Dto to Entity
        Stock stock = mapToEntity(stockDTO);
        Stock newPost = stockRepository.save(stock);
        StockDTO stockResponse = mapToDTO(newPost);
        return stockResponse;
    }

    @Override
    public StockResponse getAllStocks(int pageNo, int pageSize, String sortBy,String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Stock> stocks = stockRepository.findAll(pageable);
        List<Stock> listOfPosts = stocks.getContent();
        List<StockDTO> content= listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
        StockResponse stockResponse = new StockResponse();
        stockResponse.setContent(content);
        stockResponse.setPageNo(stocks.getNumber());
        stockResponse.setPageSize(stocks.getSize());
        stockResponse.setTotalElements(stocks.getTotalElements());
        stockResponse.setTotalPages(stocks.getTotalPages());
        stockResponse.setLast(stocks.isLast());
        return stockResponse;
    }

    @Override
    public StockDTO getStockById(long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Stock", "id", id));
        return mapToDTO(stock);
    }

    @Override
    public StockDTO updateStock(StockDTO stockDTO, long id) {
        //Get post by id from the database
        Stock stock = stockRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Stock", "id", id));
        stock.setType(stockDTO.getType());
        stock.setSymbol(stockDTO.getSymbol());
        stock.setShares(stockDTO.getShares());
        stock.setPrice(stockDTO.getPrice());
        stock.setTimestamp(stockDTO.getTimestamp());
        stock.setStock_id(stockDTO.getUser().getId());
        stock.setUser_name(stockDTO.getUser().getName());
        Stock updatedStock = stockRepository.save(stock);
        return mapToDTO(updatedStock);
    }

    @Override
    public void deleteStockById(long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Stock", "id", id));
        stockRepository.delete(stock);
    }

    @Override
    public StockDTO getStockByUserId(long userid) {
        Stock stock = stockRepository.findById(userid).orElseThrow(()->new ResourceNotFoundException("User", "id", userid));
        return mapToDTO(stock);
    }

    //Convert DTO to  Entity
    private Stock mapToEntity(StockDTO stockDTO){
        Stock stock = new Stock();
        stock.setStock_id(stockDTO.getId());
        stock.setType(stockDTO.getType());
        stock.setSymbol(stockDTO.getSymbol());
        stock.setShares(stockDTO.getShares());
        stock.setPrice(stockDTO.getPrice());
        stock.setTimestamp(stockDTO.getTimestamp());
        stock.setUser_id(stockDTO.getUser().getId());
        stock.setUser_name(stockDTO.getUser().getName());
        return stock;

    }

    private StockDTO mapToDTO(Stock stock){
        StockDTO stockDTO= new StockDTO();
        stockDTO.setId(stock.getStock_id());
        stockDTO.setType(stock.getType());
        stockDTO.setSymbol(stock.getSymbol());
        stockDTO.setShares(stock.getShares());
        stockDTO.setPrice(stock.getPrice());
        stockDTO.setTimestamp(stock.getTimestamp());
        User user = new User();
        user.setId(stock.getUser_id());
        user.setName(stock.getUser_name());
        stockDTO.setUser(user);
        return stockDTO;

    }
}
