package com.EduTech.EduTech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name="Soporte")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Soporte {

    //@Id
    //@Column(unique = true, nullable = false)
    private int idTicket;

    //@Column(nullable = false)
    private Usuario usuario;

    //@Column(nullable = false)
    private String tipoConsulta;

    //@Column(nullable = false)
    private String descripcionProblema;

}
