package com.example.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/clients")
public class ClientsController {
    private final ClientService clientService;

    @Autowired
    public ClientsController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Clients> listClient(){
        return clientService.getclient();
    }

    @PostMapping
    public void Addclient(@RequestBody Clients clients){
        clientService.addclient(clients);
    }
}
