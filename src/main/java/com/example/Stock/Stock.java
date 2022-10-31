package com.example.Stock;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private Integer quantite;
    @ManyToOne
    @JoinColumn(name="id_product")
    private Products product;

    public Stock() {
    }

    public Stock(long id, String name, Integer quantite, Products product) {
        this.id = id;
        this.name = name;
        this.quantite = quantite;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantite=" + quantite +
                ", product=" + product +
                '}';
    }
}
