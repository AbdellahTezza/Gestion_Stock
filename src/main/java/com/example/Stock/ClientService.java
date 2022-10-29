package com.example.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientsRepository clientsRepository;

    private final ProductRepository productRepository;

    @Autowired
    public ClientService(ClientsRepository clientsRepository, ProductRepository productRepository) {
        this.clientsRepository = clientsRepository;
        this.productRepository = productRepository;
    }

    public List<Clients> getclient(){
        return clientsRepository.findAll();
    }

    public void addclient(Clients clients) {
        clientsRepository.save(clients);
    }



}
