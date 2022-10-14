package com.example.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseursService {
    private final FournisseursRepository fournisseursRepository;

    @Autowired
    public FournisseursService(FournisseursRepository fournisseursRepository) {
        this.fournisseursRepository = fournisseursRepository;
    }

    public List<Fournisseurs> getfournisseurs(){
        return fournisseursRepository.findAll();
    }
    public void addfrournisseurs(Fournisseurs fournisseurs){
        fournisseursRepository.save(fournisseurs);
    }
}
