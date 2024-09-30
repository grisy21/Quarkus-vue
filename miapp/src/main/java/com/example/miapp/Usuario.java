package com.example.miapp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import jakarta.persistence.Entity;

@Entity
public class Usuario extends PanacheEntity {
    public String email;
    public String password;
}
