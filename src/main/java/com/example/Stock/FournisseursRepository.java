package com.example.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseursRepository
        extends JpaRepository<Fournisseurs, Long> {
}
