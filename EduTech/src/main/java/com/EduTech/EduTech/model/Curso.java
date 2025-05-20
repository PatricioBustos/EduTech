package com.EduTech.EduTech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Curso")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Curso{

    @Id
    @Column(unique = true, nullable = false)
    private int idCurso;

    @Column(nullable = false)
    private String nombreCurso;

    @Column(nullable = false)
    private String idUsuarioEncargado;

    @Column(nullable = false)
    private String nombreUsuarioEncargado;

}