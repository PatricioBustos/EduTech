package com.EduTech.EduTech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soporte {
    private int idTicket;
    private Usuario usuario;
    private String tipoConsulta;


}
