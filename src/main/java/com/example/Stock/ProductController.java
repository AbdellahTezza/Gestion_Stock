package com.example.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Products> getproduct() {
        return productService.getproduct();
    }

    @PostMapping
    public void register(@RequestBody Products products){
        productService.addNewproduct(products);
    }

    @DeleteMapping(path= "{produtsID}")
    public void deleteProduct(
            @PathVariable("produtsID") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping(path = "{produtsID}")
    public void updateProduct(
            @PathVariable("produtsID") Long id,
            @RequestParam(required = false) String marque,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double prix,
            @RequestParam(required = false) int stock){
        productService.updateProduct(id, marque,name, prix);
    }

}
