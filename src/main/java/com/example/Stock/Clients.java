package com.example.Stock;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany
    private Set<Products> products;

    public Clients(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Clients() {
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
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
