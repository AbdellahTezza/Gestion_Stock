package com.example.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/stock")

public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> StockList(){
        return stockService.getStock();
    }

    @PostMapping
    public void register(@RequestBody Stock stock){
        stockService.Addstock(stock);
    }
}
