package com.EduTech.EduTech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Usuario {

    @Id
    @Column(unique = true,length = 8, nullable = false)
    private String rut;

    @Column(nullable = false, length = 1)
    private String dv;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidoPaterno;

    @Column(nullable = false)
    private String apellidoMaterno;

    @Column(nullable = false, unique = true)
    private String correo;

}
