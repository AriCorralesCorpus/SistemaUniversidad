package com.universidad.sistema.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String facultad;

    @Column(length = 1000)
    private String descripcion;

    private String estado; // BORRADOR o PUBLICADA
}
