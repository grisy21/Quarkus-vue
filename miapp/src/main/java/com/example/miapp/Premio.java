package com.example;

import jakarta.persistence.*;


@Entity
@Table(name = "premios")
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String archivoAudio;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArchivoAudio() {
        return archivoAudio;
    }

    public void setArchivoAudio(String archivoAudio) {
        this.archivoAudio = archivoAudio;
    }
}
