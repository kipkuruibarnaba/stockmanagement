package com.stockmanagement.controller;
import com.stockmanagement.payload.StockDTO;
import com.stockmanagement.payload.StockResponse;
import com.stockmanagement.service.StockService;
import com.stockmanagement.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @created Barnaba Mutai
 * @created 04/ 09/ 2022 - 4:35 PM
 */

@RestController
@RequestMapping("api/stocks")
public class StockController {
    private StockService stockService;
    public StockController(StockService stockService){
        this.stockService = stockService;
    }
    @PostMapping
    public ResponseEntity<StockDTO> createStock(@RequestBody StockDTO stockDTO){
        return new ResponseEntity<>(stockService.createStock(stockDTO),HttpStatus.CREATED);
    }

    @GetMapping
    public StockResponse getAllStocks(
//    public List<PostDto> getAllPosts(
            @RequestParam(value = "pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NO,required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false) String sortDir
    ){
        return stockService.getAllStocks(pageNo,pageSize,sortBy,sortDir);
    }

    //Get single post by id
    @GetMapping("/{id}")
    public ResponseEntity<StockDTO>getStockById(@PathVariable (name="id") long id){
        return ResponseEntity.ok(stockService.getStockById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockDTO>updateStock(@RequestBody StockDTO stockDTO, @PathVariable (name="id") long id){
        StockDTO stockResponse = stockService.updateStock(stockDTO ,id);
        return new ResponseEntity<>(stockResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteStock(@PathVariable (name="id") long id){
        stockService.deleteStockById(id);
        return new ResponseEntity<>("Stock deleted successfully. ", HttpStatus.OK);
    }


    //Get posts by user id
    @GetMapping("/{userId}/stocks")
    public ResponseEntity<StockDTO>getStockByUserId(@PathVariable (name="userId") long userid){
        return ResponseEntity.ok(stockService.getStockByUserId(userid));
    }
}
