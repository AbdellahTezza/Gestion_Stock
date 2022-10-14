package com.example.Stock;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name, marque;
    private Integer stock;
    private double prix;


    public Products() {
    }

    public Products(String name,
                    String marque,
                    Integer stock,
                    double prix)
    {
        this.name = name;
        this.marque = marque;
        this.stock = stock;
        this.prix = prix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }



    @ManyToOne
    @JoinColumn(name="idFournisseurs" )
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Fournisseurs fournisseurs;


    public Products(Fournisseurs fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    public Fournisseurs getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(Fournisseurs fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marque='" + marque + '\'' +
                ", stock=" + stock +
                ", prix=" + prix +
                ", fournisseurs=" + fournisseurs +
                '}';
    }
}
