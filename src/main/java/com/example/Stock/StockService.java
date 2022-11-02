package com.example.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private final StockRepository stockRepository;

    @Autowired
    private final ProductRepository productRepository;

    public StockService(StockRepository stockRepository, ProductRepository productRepository) {
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    public List<Stock> getStock(){
        return stockRepository.findAll();
    }

    public void Addstock(Stock stock){
        System.out.println("Service entre " +stock);
        stock.setQuantite(2);
        Long id_product = stock.getProduct().getId();
        Products products = productRepository.getReferenceById(id_product);
        System.out.println(products);
        stock.setProduct(products);
        System.out.println("Service sortie " +stock);
        stockRepository.save(stock);
    }


}
