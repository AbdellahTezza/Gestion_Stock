package com.example.Stock;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fournisseurs")
public class Fournisseurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;

    public Fournisseurs() {
    }

    public Fournisseurs(long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Fournisseurs{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }

}
