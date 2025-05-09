package com.EduTech.EduTech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {

    private int rut;
    private String dv;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;

}
