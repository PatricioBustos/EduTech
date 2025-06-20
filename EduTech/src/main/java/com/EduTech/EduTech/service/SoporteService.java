package com.EduTech.EduTech.service;

import com.EduTech.EduTech.model.Soporte;
import com.EduTech.EduTech.repository.SoporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SoporteService {

    @Autowired
    private SoporteRepository soporteRepository;

    public List<Soporte> findAll() {return soporteRepository.obtenerSoportes();}

    public Soporte saveSoporte(Soporte soporte) {

        if (soporteRepository.buscarPorId(soporte.getIdTicket()) != null) {
            throw new RuntimeException("Ya existe un soporte con este ID");
        }

        if (soporte.getTipoConsulta() == null || soporte.getTipoConsulta().isBlank()) {
            throw new IllegalArgumentException("El tipo de consulta es obligatorio");
        }

        if (soporte.getDescripcionProblema() == null || soporte.getDescripcionProblema().isBlank()) {
            throw new IllegalArgumentException("La descripción es obligatoria");
        }

        if (soporte.getUsuario() == null) {
            throw new IllegalArgumentException("El soporte debe estar asociado a un usuario");
        }

        return soporteRepository.guardarTicket(soporte);
    }

    public Soporte updateTicket(Soporte soporte){
        if (soporteRepository.buscarPorId(soporte.getIdTicket()) == null) {
            throw new RuntimeException("idTicekt no existente");
        }
        return soporteRepository.actualizarTicket(soporte);
    }

    public String deleteTicket(int idTicket) {
        Soporte soporte = soporteRepository.buscarPorId(idTicket);
        if (soporte == null) {
            throw new RuntimeException("Ticket con ID : " + idTicket + " no encontrado.");
        }
        soporteRepository.eliminarTicket(idTicket);
        return "Id ticket: " + idTicket + " eliminado correctamente.";
    }

    public Soporte findById(int idTicket) {
        Soporte soporte = soporteRepository.buscarPorId(idTicket);
        if(soporte == null){
            throw new RuntimeException("No se encontró el ticket : " + idTicket);
        }
        return soporte;
        }
    }
