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

    @ManyToOne
    @JoinColumn(name="id_fournisseur" )
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore

    private Fournisseurs fournisseur;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clients_id")
    private Clients clients;


    public Products() {
    }

    public Products(long id, String name, String marque, Integer stock, double prix, Fournisseurs fournisseur, Clients clients) {
        this.id = id;
        this.name = name;
        this.marque = marque;
        this.stock = stock;
        this.prix = prix;
        this.fournisseur = fournisseur;
        this.clients = clients;
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

    public Fournisseurs getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseurs fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marque='" + marque + '\'' +
                ", stock=" + stock +
                ", prix=" + prix +
                ", fournisseur=" + fournisseur +
                ", clients=" + clients +
                '}';
    }
}