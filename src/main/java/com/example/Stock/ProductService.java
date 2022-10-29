package com.example.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final FournisseursRepository fournisseursRepository;

    @Autowired
    private final ClientsRepository clientsRepository;
    public ProductService(ProductRepository productRepository, FournisseursRepository fournisseursRepository, ClientsRepository clientsRepository) {
        this.productRepository = productRepository;
        this.fournisseursRepository = fournisseursRepository;
        this.clientsRepository = clientsRepository;
    }


    public List<Products> getproduct() {
        return productRepository.findAll();
    }

    public void addNewproduct(Products products) {
        Long FournisseurId = products.getFournisseur().getId();
        Fournisseurs fournisseurs = fournisseursRepository.getReferenceById(FournisseurId);
        System.out.println(fournisseurs);
        products.setFournisseur(fournisseurs);

        Long id_client = products.getClients().getId();
        Clients clients = clientsRepository.getReferenceById(id_client);
        System.out.println(clients);
        products.setClients(clients);
        productRepository.save(products);
    }

    public void deleteProduct(Long id) {
        boolean exists = productRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "product with id"  +  id + "does not exists"
            );
        }
        productRepository.deleteById(id);
    }

    @Transactional
    public void updateProduct(Long id, String marque, String name, Double prix, Integer stock) {
        Products products = productRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "product1 with id " + id + "does not exists"));

        if(marque != null && marque.length() > 0 && !Objects.equals(products.getMarque(), marque)){
            products.setMarque(marque);
        }

        if(name != null && name.length() > 0 && !Objects.equals(products.getName(), name)){
            products.setName(name);
        }

        if(prix != null && !Objects.equals(products.getPrix(), prix)){
            products.setPrix(prix);
        }

        if(stock != null && !Objects.equals(products.getStock(), stock)){
            products.setStock(stock);
        }

    }
}