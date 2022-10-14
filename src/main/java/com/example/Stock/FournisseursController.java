package com.example.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/fournisseurs")
public class FournisseursController {
    private final FournisseursService fournisseursService;

    @Autowired
    public FournisseursController(FournisseursService fournisseursService) {
        this.fournisseursService = fournisseursService;
    }

    @GetMapping
    public List<Fournisseurs> FournisseursList() {
        return fournisseursService.getfournisseurs();
    }

    @PostMapping
    public void register(@RequestBody Fournisseurs fournisseurs){
        fournisseursService.addfrournisseurs(fournisseurs);
    }

}
