package com.EduTech.EduTech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Soporte")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soporte {

    @Id
    @Column(unique = true, nullable = false)
    private int idTicket;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_rut") // nombre columna FK en Soporte
    private Usuario usuario;

    @Column(nullable = false)
    private String tipoConsulta;

    @Column(nullable = false)
    private String descripcionProblema;
}
