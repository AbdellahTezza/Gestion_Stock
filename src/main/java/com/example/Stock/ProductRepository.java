package com.example.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository
        extends JpaRepository<Products, Long> {
        public Products findById(int id);
}
